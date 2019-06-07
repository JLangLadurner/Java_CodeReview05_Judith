package codereview.products;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
                  3.49,2.79, "/Resources/pfeffer__600x600.jpg"),
          new Product("Schafmilchkäse", "200 Gramm Packung",
                  "Hier gibt es keine Beschreibung, weil unsere Handelskette kennst sich nur bedingt damit aus, wie man eine Werbebeschreibung schreibt.",
                  3.59,1.99, "/Resources/cheese_salakis__600x600.jpg"),
          new Product("Vöslauer", "1.5 Spritziges Vöslauer Mineralwasser", "Spritziges Vöslauer Mineralwasser.",
                  0.75,0.49, "/Resources/voslauer__600x600.jpg"),
          new Product("Zucker", "500 Gramm Paket",
                  "Natürliches Gelieren wird durch Apfelpektin unterstützt, welches im richtigen Verhältnis mit Zitronensäure und Kristallzucker abgemischt wurde.",
                  1.39,0.89,"/Resources/zucker__600x600.jpg")
        );


        //create ListView with Products in it
        ListView<Product> list = new ListView<>();
        list.setItems(items);

        //Create Text Fields with Labels:

        TextField prodTitleField =  new TextField("");
            prodTitleField.setEditable(false);//renders the field unable to be edited
            prodTitleField.setDisable(false);//will not me grey
        Label prodTitelLabel = new Label("Prod. Name");
        TextField prodQuantField = new TextField("");
            prodQuantField.setEditable(false);
            prodQuantField.setDisable(false);
        Label prodQuantLabel = new Label("Quantity");
        TextField prodDescField = new TextField("");
            prodDescField.setEditable(false);
            prodDescField.setDisable(false);
        Label prodDescLabel = new Label ("Description");
        TextField oldPriceField = new TextField("");
            oldPriceField.setEditable(false);
            oldPriceField.setDisable(false);
        Label oldPriceLabel = new Label("Old Price");
        Label euroText1 = new Label("€");
        TextField newPriceField = new TextField("");
        Label newPriceLabel = new Label("New Price");
        Label euroText2 = new Label("€");
        ImageView imageView = new ImageView();
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
        HBox imageBox = new HBox(imageView);
        imageBox.setPadding(new Insets(0,0,0,5));

    //create Buttons - add and delete buttons are not in use in this example
    //Button addNewItem = new Button ("ADD");
    //addNewItem.setStyle("-fx-background-color:palegreen");

        Button clearFields = new Button("Clear");
        clearFields.setStyle("-fx-background-color:powderblue");

    //Button deleteSelected = new Button("Delete");
    //deleteSelected.setStyle("-fx-background-color: tomato");

        Button updateItem = new Button("Update");
        updateItem.setStyle("-fx-background-color:Peachpuff");
        Button printReport = new Button("Report");
        printReport.setStyle("-fx-background-color:silver");

        //create layout

        HBox prodTitle = new HBox(prodTitelLabel,prodTitleField);
        prodTitle.setSpacing(25);
        prodTitle.setAlignment(Pos.CENTER_LEFT);
        HBox prodDesc = new HBox(prodDescLabel,prodDescField);
        prodDesc.setSpacing(25);
        HBox prodQuant = new HBox(prodQuantLabel,prodQuantField);
        prodQuant.setSpacing(35);
        HBox oldPrice = new HBox(oldPriceLabel,oldPriceField, euroText1);
        oldPrice.setSpacing(30);
        HBox newPrice = new HBox(newPriceLabel,newPriceField,euroText2 );
        newPrice.setSpacing(28);
        HBox buttons = new HBox(updateItem,clearFields,printReport);
        buttons.setAlignment(Pos.CENTER_RIGHT);
        buttons.setSpacing(10);

        VBox mainProdBox = new VBox(prodTitle, prodDesc, prodQuant, oldPrice,newPrice,imageBox,buttons);
        mainProdBox.setSpacing(10);
        mainProdBox.setPrefWidth(400);

        VBox listBox = new VBox(list);
        listBox.setPrefWidth(300);

        HBox mainBox = new HBox(mainProdBox,listBox);
        mainBox.setSpacing(10);
        mainBox.setPadding(new Insets(5,5,5,5));

        Scene scene = new Scene(mainBox, 650,450);
        primaryStage.setScene(scene);
        primaryStage.show();

        //Controll
        //1. prints item in Fields and shows picture when item is selected on the left hand side:
        list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String  oldP = Double.toString(newValue.getOldPrice());
            String newP = Double.toString(newValue.getNewPrice());

            prodTitleField.setText(newValue.getProductTitle());
            prodQuantField.setText(newValue.getProductQuant());
            prodDescField.setText(newValue.getProductDesc());
            oldPriceField.setText(oldP);
            newPriceField.setText(newP);
            imageView.setImage(new Image(this.getClass().getResourceAsStream(newValue.getImagePath())));
        });
        //clears Fields when clear button is pressed
        clearFields.setOnAction(actionEvent ->  {
            System.out.println("clear clicked");
            prodTitleField.setText("");
            prodQuantField.setText("");
            prodDescField.setText("");
            oldPriceField.setText("");
            newPriceField.setText("");
            imageView.setImage(new Image(this.getClass().getResourceAsStream("")));

        });
            //action update
            updateItem.setOnAction(actionEvent ->  {
            System.out.println("update clicked");
            int selIdx = list.getSelectionModel().getSelectedIndex();
            Double newP = Double.valueOf(newPriceField.getText());
            if (selIdx != -1) {
                String prodTitleFieldText = prodTitleField.getText();
                String prodQuantFieldText = prodQuantField.getText();
                String prodDescFieldText = prodQuantField.getText();
                String oldPriceText = oldPriceField.getText();
                String newPriceText = newPriceField.getText();
                list.getItems().get(selIdx).setNewPrice(newP);
                list.refresh();
                updateComplete();
            }else{
                noSelection();
            }

            });
            //action for report:
            printReport.setOnAction(report -> {
                try {
                    writeReport(items);
                    successReport();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            }



            //print report in new file - see source folder
            private void writeReport(ObservableList <Product> items) throws IOException {
                FileWriter fileWriter = new FileWriter("./src/report.txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                items.forEach(data ->{
                    printWriter.println(data.getProductTitle());
                    printWriter.println(data.getProductQuant());
                    printWriter.println(data.getProductDesc());
                    printWriter.println("Old Price " + data.getOldPrice() + "€");
                    printWriter.println("New Price" + data.getNewPrice() + "€");
                    printWriter.println("");
                });
                printWriter.close();
            }

            //if report has been successfully printed - show this message

            private void successReport(){
                Alert successReport = new Alert(Alert.AlertType.INFORMATION);
                successReport.setTitle("Success");
                successReport.setHeaderText(null);
                successReport.setContentText("\"Report\" successfully created.");
                successReport.showAndWait();
            }
            //if nothing is selected  - show alert
                private void noSelection(){
                    Alert noSelection = new Alert(Alert.AlertType.ERROR);
                    noSelection.setTitle("Error");
                    noSelection.setHeaderText(null);
                    noSelection.setContentText("Please select the item from the list you want to update.");
                    noSelection.showAndWait();
                }
            //if update has been completed - show success message
                private void updateComplete(){
                    Alert updateComplete = new Alert(Alert.AlertType.INFORMATION);
                    updateComplete.setTitle("Success");
                    updateComplete.setHeaderText(null);
                    updateComplete.setContentText("Update completed.");
                    updateComplete.showAndWait();
            }

            public static void main(String[] args) {
                Application.launch(args);
            }
    }//ends class main

