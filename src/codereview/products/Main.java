package codereview.products;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

//src path : "/Resources/coffee-icon.png"
public class Main extends Application {

    @Override
    public void start(Stage primaryStage)throws Exception{
        //setTitel
        primaryStage.setTitle("Product Price Update");

        ObservableList<Product> items = FXCollections.observableArrayList(
          //create Products
          new Product("Pfeffer", "1 Stück",
                  "Schwarzer Pfeffer verleiht Ihren Speisen eine pikante Schärfe, besonders wenn er länger mitgekocht wird. ",
                  3.49,2.79),
          new Product("Schafmilchkäse", "200 Gramm Packung",
                  "Hier gibt es keine Beschreibung, weil unsere Handelskette kennst sich nur bedingt damit aus, wie man eine Werbebeschreibung schreibt.",
                  3.59,1.99),
          new Product("Vöslauer", "1.5 Spritziges Vöslauer Mineralwasser", "Spritziges Vöslauer Mineralwasser.",
                  0.75,0.49),
          new Product("Zucker", "500 Gramm Paket",
                  "Natürliches Gelieren wird durch Apfelpektin unterstützt, welches im richtigen Verhältnis mit Zitronensäure und Kristallzucker abgemischt wurde.",
                  1.39,0.89)
        );
    }



}
