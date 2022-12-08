package controller;

import infastructure.IRepository;
import infastructure.ViewManager;
import model.ShoppingCart;
import view.IProductView;

import javax.swing.*;

public class ProductController {

    private IRepository<ShoppingCart> _shoppingCart;

    private ViewManager _viewManager;

    private IProductView _productView;

    public ProductController(ViewManager viewManager, IProductView productView) {
        this._viewManager = viewManager;
        this._productView = productView;

        this._productView.handleAddToCart(e -> {
            JOptionPane.showMessageDialog(null,
                    "Username or Password is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
        });
    }
}
