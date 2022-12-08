package view;

import controller.ProductController;
import infastructure.IRepository;
import infastructure.Observer;
import model.Product;
import model.ShoppingCart;
import model.User;
import model.UserType;
import view.utility.ProductCardFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class ProductsView extends JPanel implements Observer<IRepository<Product>> {

    private IRepository<Product> _products;

    private ProductCardFactory _productCardFactory;

    private GridBagConstraints _gbc;
    private JPanel _productsPanel;

    private JTextField _search;

    public ProductsView(IRepository<Product> products, ProductCardFactory productCardFactory) {
        this._products = products;
        this._productCardFactory = productCardFactory;
        initializeComponents();
    }

    private void initializeComponents() {
        this.removeAll();

        this.setLayout(new GridBagLayout());
        _gbc = new GridBagConstraints();

        JLabel label = new JLabel("Products");
        label.setFont(new Font("Courier", Font.BOLD, 22));

        _gbc.gridy = 0;
        _gbc.gridx = 0;
        _gbc.gridwidth = 1;
        _gbc.fill = GridBagConstraints.HORIZONTAL;
        _gbc.insets = new Insets(0, 0, 0, 50);
        this.add(label, _gbc);

        _gbc.gridy = 0;
        _gbc.gridx = 1;
        _gbc.gridwidth = 1;
        _gbc.insets = new Insets(0, 0, 0, 10);

        JLabel searchLabel = new JLabel("Search: ");
        this.add(searchLabel, _gbc);

        _search = new JTextField();
        _search.setName("Search");

        _gbc.gridx = 2;
        _gbc.gridwidth = 2;
        _gbc.fill = GridBagConstraints.HORIZONTAL;
        _gbc.insets = new Insets(0, 0, 0, 0);
        this.add(_search, _gbc);


        _gbc.gridy += 1;
        _gbc.gridx = 0;
        _gbc.gridwidth = 4;
        _gbc.insets = new Insets(20, 0, 0, 0);
        renderProducts();
    }

    public String getSearch() {
        return _search.getText();
    }

    public void handleSearch(KeyListener e) {
        _search.addKeyListener(e);
    }

    @Override
    public void update(IRepository<Product> obj) {
        _products = obj;
        renderProducts();
    }

    private void renderProducts() {
        if(_productsPanel != null) {
            this.remove(_productsPanel);
            this.revalidate();
            this.updateUI();
            _productsPanel = null;
            this.renderProducts();
        } else {
            GridLayout grid = new GridLayout(0,4);
            grid.setHgap(10);
            grid.setVgap(10);

            _productsPanel = new JPanel();
            _productsPanel.setLayout(grid);
            for(Product product : _products.list())
            {
                var productCard = _productCardFactory.createProductCardView(product);
                _productsPanel.add(productCard);
            }

            this.add(_productsPanel, _gbc);
        }

    }
}
