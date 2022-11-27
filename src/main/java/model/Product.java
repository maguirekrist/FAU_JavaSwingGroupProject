package model;

import java.util.Date;

public class Product extends Entity {

    private User seller;
    private String label;
    private String description;
    private double cost;
    private double price;
    private int quantity;
    private String image_url;

    private Date createdOn;

    public Product(String label, double price, double cost, int quantity, String description) {
        this.label = label;
        this.price = price;
        this.cost = cost;
        this.quantity = quantity;
        this.description = description;
        this.createdOn = new Date();
    }

    public void AssignSeller(User user){
        this.seller = user;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
