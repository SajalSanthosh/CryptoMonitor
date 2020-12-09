package Controller;

import Model.CoinList;
import Utils.GeckoUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable
{
    @FXML
    private ComboBox<CoinList> cryptoList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        CoinList[] coinLists = GeckoUtils.getAllCoins();
        cryptoList.getItems().addAll(coinLists);
    }

    @FXML
    void onCoinListSelected(ActionEvent event) {
        CoinList coinList = cryptoList.getValue();
        System.out.println();
    }

}
