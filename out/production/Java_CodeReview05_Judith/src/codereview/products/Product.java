package codereview.products;


import javafx.scene.image.Image;

import java.io.InputStream;

public class Product {

    private String productTitle;
    private String productQuant;
    private String productDesc;
    private Double oldPrice;
    private Double newPrice;


    public Product(String productTitel, String productQuant, String productDesc, double oldPrice, double newPrice){
        this.productTitle = productTitel;
        this.productQuant = productQuant;
        this.productDesc = productDesc;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;

    }

    @Override
    public String toString() {
        return "{" +
                "'" + productTitle + '\'' +
                ", old=" + oldPrice +
                ", new=" + newPrice +
                '}';
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getProductQuant() {
        return productQuant;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public Double getNewPrice() {
        return newPrice;
    }


    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }
}

