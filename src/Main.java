import Utils.GeckoUtils;
import Utils.HttpUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application
{
    public static void main(String[] args)
    {

//        GeckoUtils.getCoinMarketChart("bitcoin");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("View/mainView.fxml"));
        primaryStage.setTitle("Crypto  Monitor");
        primaryStage.getIcons().add(new Image("crypto.png"));
        Scene scene = new Scene(root);
//        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
