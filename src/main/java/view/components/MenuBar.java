package view.components;

import infastructure.Observer;
import infastructure.UserSession;
import model.User;
import model.UserType;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class MenuBar extends JMenuBar implements Observer<UserSession> {

    private JMenuItem _logout;
    private JMenuItem _addProduct;
    private JMenuItem _myStore;

    private JMenu _homeMenu;
    private JMenu _shoppingCartMenu;

    private JMenu _accountMenu;

    public MenuBar() {
        initializeComponents();
    }

    private void initializeComponents() {
        this.removeAll();
        this.setBorderPainted(true);

        _homeMenu = new JMenu("Home");
        this.add(_homeMenu);

        this.add(Box.createHorizontalGlue());

        _accountMenu = new JMenu("Account");

        _logout = new JMenuItem("Logout");
        _addProduct = new JMenuItem("Add new product");
        _myStore = new JMenuItem("My products");

        _accountMenu.add(_logout);
        _accountMenu.add(_myStore);
        _accountMenu.add(_addProduct);

        _shoppingCartMenu = new JMenu("My Cart");
        this.add(_shoppingCartMenu);

        this.add(_accountMenu);

        toggleVisibility();
    }

    public void handleLogout(ActionListener e) {
        _logout.addActionListener(e);
    }

    public void handleCart(ActionListener e) {
        _shoppingCartMenu.addActionListener(e);
    }

    public void handleAddProduct(ActionListener e) {
        _addProduct.addActionListener(e);
    }

    public void handleStore(ActionListener e) {
        _myStore.addActionListener(e);
    }

    public void handleHome(MouseAdapter e) {
        _homeMenu.addMouseListener(e);
    }

    @Override
    public void update(UserSession obj) {
        System.out.println(UserSession.getSession().isAuthenticated());
        toggleVisibility();
    }

    private void toggleVisibility() {
        if(UserSession.getSession().isAuthenticated() && UserSession.getSession().getUser().getUserType() == UserType.SELLER) {
            _myStore.setVisible(true);
            _addProduct.setVisible(true);
        } else {
            _myStore.setVisible(false);
            _addProduct.setVisible(false);
        }

        if(UserSession.getSession().isAuthenticated() && UserSession.getSession().getUser().getUserType() == UserType.CUSTOMER) {
            _shoppingCartMenu.setVisible(true);
        } else {
            _shoppingCartMenu.setVisible(false);
        }

        if(UserSession.getSession().isAuthenticated()) {
            _accountMenu.setVisible(true);
        } else {
            _accountMenu.setVisible(false);
        }
    }
}
