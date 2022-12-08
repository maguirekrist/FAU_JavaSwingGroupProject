package controller;

import infastructure.UserSession;
import infastructure.ViewManager;
import view.components.MenuBar;
import view.utility.Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuBarController {

    private ViewManager _viewManager;

    private MenuBar _menuBar;

    public MenuBarController(ViewManager viewManager, MenuBar menuBar) {
        this._viewManager = viewManager;
        this._menuBar = menuBar;

        //register observers
        UserSession.getSession().addObserver(menuBar);

        //register events
        _menuBar.handleLogout(this::logout);
        _menuBar.handleHome(home());
        _menuBar.handleAddProduct(this::addProduct);
    }

    private void logout(ActionEvent e) {
        UserSession.getSession().signOut();
        _viewManager.changeView(Views.Login);
    }

    private void addProduct(ActionEvent e) {
        _viewManager.changeView(Views.AddProduct);
    }

    private MouseAdapter home() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                _viewManager.changeView(Views.Home);
            }
        };
    }
}
