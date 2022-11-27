package controller;

import infastructure.ViewManager;
import view.components.MenuBar;
import view.utility.Views;

import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuBarController {

    private ViewManager _viewManager;

    private MenuBar _menuBar;

    public MenuBarController(ViewManager viewManager, MenuBar menuBar) {
        this._viewManager = viewManager;
        this._menuBar = menuBar;

        //register events
        _menuBar.handleLogout(this::logout);
        _menuBar.handleHome(this::home);
        _menuBar.handleAddProduct(this::addProduct);
    }

    private void logout(ActionEvent e) {

    }

    private void addProduct(ActionEvent e) {
        _viewManager.changeView(Views.AddProduct);
    }

    private void home(ActionEvent e) {
        _viewManager.changeView(Views.Home);
    }
}
