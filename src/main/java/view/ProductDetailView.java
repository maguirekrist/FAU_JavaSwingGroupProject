package view;

import model.Product;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ProductDetailView extends JPanel implements IProductView {

    private Product _product;



    public ProductDetailView(Product product) {
        this._product = product;

        initializeComponents();
    }

    private void initializeComponents() {

    }

    @Override
    public void handleAddToCart(ActionListener e) {

    }

    @Override
    public Product getProduct() {
        return _product;
    }
}
