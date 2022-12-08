package view;

import model.Product;

import java.awt.event.ActionListener;

//sets an interface for product views
//Multiple views should implement the same actions, i.e., product views should know how to be told what View element adds items to the cart
public interface IProductView {

    void handleAddToCart(ActionListener e);

    Product getProduct();

}
