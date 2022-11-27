package view;

import infastructure.IRepository;
import infastructure.Observer;
import model.Product;
import model.ShoppingCart;
import model.User;
import model.UserType;

import javax.swing.*;
import java.awt.*;

public class ProductsView extends JPanel implements Observer<IRepository<Product>> {

    private IRepository<Product> _products;

    public ProductsView(IRepository<Product> products) {
        this._products = products;
        initializeComponents();
    }

    private void initializeComponents() {
        this.removeAll();

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel panel = new JPanel();

        GridLayout grid = new GridLayout(0,2);
        grid.setHgap(5);
        grid.setVgap(5);

        panel.setLayout(grid);
        for(Product product : _products.list())
        {
            panel.add(new ProductCardView(product));
        }
        this.add(panel, gbc);
    }

    @Override
    public void update(IRepository<Product> obj) {
        _products = obj;
        initializeComponents();
    }
}
