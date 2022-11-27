package view.components;

import model.User;
import model.UserType;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {

    private JMenuItem _logout;
    private JMenuItem _addProduct;
    private JMenuItem _myStore;

    private JMenu _homeMenu;
    private JMenu _shoppingCartMenu;

    public MenuBar(User user) {
        this.activeUser = user;
        initializeComponents();
    }

    private void initializeComponents() {
        this.setBorderPainted(true);

        _homeMenu = new JMenu("Home");
        this.add(_homeMenu);

        this.add(Box.createHorizontalGlue());

        JMenu accountMenu = new JMenu("Account");
        _logout = new JMenuItem("Logout");
        _addProduct = new JMenuItem("Add new product");
        _myStore = new JMenuItem("My products");

        accountMenu.add(_logout);
        if(activeUser.getUserType() == UserType.SELLER) {
            accountMenu.add(_myStore);
            accountMenu.add(_addProduct);
        }
        this.add(accountMenu);

        if(activeUser.getUserType() == UserType.CUSTOMER) {
            _shoppingCartMenu = new JMenu("My Cart");
            this.add(_shoppingCartMenu);
        }
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

    public void handleHome(ActionListener e) {
        _homeMenu.addActionListener(e);
    }

    private User activeUser;

}
