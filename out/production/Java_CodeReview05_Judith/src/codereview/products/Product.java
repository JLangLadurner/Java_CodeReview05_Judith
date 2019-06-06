package codereview.products;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.InputStream;

public class Product extends Application{
    @Override
    public void start(Stage primaryStage)throws Exception {
        primaryStage.setTitle("ImageView Experiment");

        InputStream input = this.getClass().getResourceAsStream("/Resources/coffee-icon.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        HBox hbox = new HBox(imageView);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);

        Scene scene = new Scene(hbox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
