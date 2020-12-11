package Controller;

import Model.CoinList;
import Model.CoinMarketChart;
import Model.CoinMarketData;
import Utils.GeckoUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
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

    @FXML
    private AreaChart<?, ?> lineGraph;

    @FXML
    private CategoryAxis categoryAxis;

    @FXML
    private NumberAxis numberAxis;

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
        lineGraph.getData().clear();
        CoinMarketData coinMarketData = GeckoUtils.getCoinMarketData(coinList.getId());

        cryptoPrice.setText(coinMarketData.getMarketData().getCurrentPrice().getUsd());
        cryptoPriceUnit.setText(coinList.getSymbol().toUpperCase() + "/USD");
        cryptoHigh24.setText("24H High : " + coinMarketData.getMarketData().getHigh24h().getUsd());
        cryptoLow24.setText("24H Low : " + coinMarketData.getMarketData().getLow24h().getUsd());
        String change24h = coinMarketData.getMarketData().getPriceChangePercentage24h();
        if(change24h == null)
            return;
        if (Double.parseDouble(change24h) > 0)
        {
            cryptoChange24.setStyle("-fx-text-fill: green");
        } else
        {
            cryptoChange24.setStyle("-fx-text-fill: red");
        }

        cryptoChange24.setText(change24h + " %");

        CoinMarketChart coinMarketChart = GeckoUtils.getCoinMarketChart(coinList.getId());
        lineGraph.getData().clear();
        lineGraph.setAnimated(true);
        XYChart.Series cryptohistory = new XYChart.Series();
        numberAxis.setLabel("USD");
        categoryAxis.setLabel("Time");
        cryptohistory.setName(coinList.getSymbol().toUpperCase());
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");

        Map<Long, Double> marketPriceHistory = coinMarketChart.getPrices();
        for (Map.Entry<Long, Double> entry : marketPriceHistory.entrySet())
        {
            cryptohistory.getData().addAll(new XYChart.Data(DateFor.format(new Date(entry.getKey())), entry.getValue()));
        }

        lineGraph.getData().addAll(cryptohistory);
        lineGraph.setAnimated(false);
    }

}
