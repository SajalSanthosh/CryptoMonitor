package Controller;

import Model.CoinList;
import Model.CoinMarketData;
import Utils.GeckoUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class MainViewController implements Initializable
{
    @FXML
    private ComboBox<CoinList> cryptoList;

    @FXML
    private Label cryptoPrice;

    @FXML
    private Label cryptoPriceUnit;

    @FXML
    private Label cryptoHigh24;

    @FXML
    private Label cryptoLow24;

    @FXML
    private Label cryptoChange24;

    @FXML
    private ImageView footerImg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        CoinList[] coinLists = GeckoUtils.getAllCoins();
        cryptoList.getItems().addAll(coinLists);
        footerImg.setImage(new Image("graph-dark.png"));
        updateCrypto(new CoinList("bitcoin", "BTC", "Bitcoin"));
    }

    @FXML
    void onCoinListSelected(ActionEvent event)
    {
        CoinList coinList = cryptoList.getValue();
        updateCrypto(coinList);
    }

    private void updateCrypto(CoinList coinList)
    {
        CoinMarketData coinMarketData = GeckoUtils.getCoinMarketData(coinList.getId());

        cryptoPrice.setText(coinMarketData.getMarketData().getCurrentPrice().getUsd());
        cryptoPriceUnit.setText(coinList.getSymbol().toUpperCase() + "/USD");
        cryptoHigh24.setText("24H High : " + coinMarketData.getMarketData().getHigh24h().getUsd());
        cryptoLow24.setText("24H Low : " + coinMarketData.getMarketData().getLow24h().getUsd());
        String change24h = coinMarketData.getMarketData().getPriceChangePercentage24h();
        if(Double.parseDouble(change24h) > 0)
        {
            cryptoChange24.setStyle("-fx-text-fill: green");
        }else
        {
            cryptoChange24.setStyle("-fx-text-fill: red");
        }

        cryptoChange24.setText(change24h + " %");
    }

}
