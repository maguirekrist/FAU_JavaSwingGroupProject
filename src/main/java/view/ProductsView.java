package view;

import infastructure.IRepository;
import infastructure.Observer;
import model.Product;
import model.ShoppingCart;
import model.User;
import model.UserType;

import javax.swing.*;
import java.awt.*;

public class ProductsView extends JPanel implements Observer<ShoppingCart> {

    private IRepository<Product> _products;

    public ProductsView(IRepository<Product> products) {
        this._products = products;

        User user = new User(
                "maguireK",
                "pass123",
                UserType.CUSTOMER
        );

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel panel = new JPanel();

        GridLayout grid = new GridLayout(0,2);
        grid.setHgap(5);
        grid.setVgap(5);

        panel.setLayout(grid);
        for(Product product : products.list())
        {
            panel.add(new ProductCardView(product));
        }

        this.add(panel, gbc);
    }

    @Override
    public void update(ShoppingCart obj) {

    }
}
