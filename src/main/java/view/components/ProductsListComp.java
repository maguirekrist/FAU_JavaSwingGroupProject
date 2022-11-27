package view.components;

import infastructure.Observer;
import infastructure.Pair;
import model.Product;
import model.ShoppingCart;

import javax.swing.*;

public class ProductsListComp extends JPanel implements Observer<ShoppingCart> {

    public ProductsListComp() {}

    @Override
    public void update(ShoppingCart obj) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for(Pair<Product, Integer> product : obj.getProducts())
        {
            JLabel temp = new JLabel();
            temp.setText(product.getKey().getLabel());
            this.add(temp);
        }
    }
}
