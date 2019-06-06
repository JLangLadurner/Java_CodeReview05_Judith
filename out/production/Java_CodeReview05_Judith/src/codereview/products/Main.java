package codereview.products;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

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


    //create ListView with Products in it
    ListView<Product> list = new ListView<>();
    list.setItems(items);

    //Create Text Fields with Labels:

    TextField prodTitleField =  new TextField("");
    Label prodTitelLabel = new Label("Product Name");
    TextField prodQuantField = new TextField("");
    Label prodQuantLabel = new Label("Quanity");
    TextField prodDescField = new TextField("");
    Label prodDescLabel = new Label ("Description");
    TextField oldPriceField = new TextField("");
    Label oldPriceLabel = new Label("Old Price");
    TextField newPriceField = new TextField("");
    Label newPriceLabel = new Label("New Price");

    //create Buttons
    Button addNewItem = new Button ("ADD");
    addNewItem.setStyle("-fx-background-color:palegreen");
    Button clearFields = new Button("Clear");
    clearFields.setStyle("-fx-background-color:powderblue");
    Button deleteSelected = new Button("Delete");
    deleteSelected.setStyle("-fx-background-color: tomato");
    Button updateItem = new Button("Update");
    updateItem.setStyle("-fx-background-color:Peachpuff");
    Button printReport = new Button("Report");
    printReport.setStyle("-fx-background-color:silver");

    //create layout

        HBox prodTitle = new HBox(prodDescField,prodTitelLabel);
        prodTitle.setSpacing(20);
        HBox prodDesc = new HBox(prodDescField,prodDescLabel);
        prodDesc.setSpacing(20);
        HBox prodQuant = new HBox(prodQuantField,prodQuantLabel);
        prodQuant.setSpacing(20);
        HBox oldPrice = new HBox(oldPriceField, oldPriceLabel);
        oldPrice.setSpacing(20);
        HBox newPrice = new HBox(newPriceField, newPriceLabel);
        newPrice.setSpacing(20);
        HBox buttons = new HBox(addNewItem,deleteSelected,updateItem,clearFields,printReport);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);

        VBox mainProdBox = new VBox(prodTitle, prodDesc, prodQuant, oldPrice,newPrice,buttons);
        mainProdBox.setSpacing(10);

        VBox listBox = new VBox(list);
        listBox.setPrefWidth(300);

        HBox mainBox = new HBox(mainProdBox,listBox);
        mainBox.setSpacing(10);
        mainBox.setPadding(new Insets(5,5,5,5));

        Scene scene = new Scene(mainBox, 650,450);
        primaryStage.setScene(scene);
        primaryStage.show();

        //Controll
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
