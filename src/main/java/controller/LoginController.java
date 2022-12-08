package controller;

import infastructure.IRepository;
import infastructure.UserSession;
import infastructure.ViewManager;
import infastructure.repository.IUserRepository;
import model.User;
import view.LoginView;
import view.utility.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginController {

    private IUserRepository _userRepository;
    private LoginView _loginView;

    private ViewManager _viewManager;

    public LoginController(ViewManager viewManager, LoginView loginView, IUserRepository userRepository) {
        this._viewManager = viewManager;
        this._loginView = loginView;
        this._userRepository = userRepository;

        this._loginView.attemptLogin(e -> {
            String username = this._loginView.getUsername();
            String password = this._loginView.getPassword();
            if(username.length() > 0 && password.length() > 0)
            {
                if(_userRepository.isValidLogin(username, password)) {
                    //set active user singleton
                    UserSession.getSession().signIn(_userRepository.findByUsername(username).get());
                    _viewManager.changeView(Views.Home);
                } else {
                    this._loginView.toggleFormError();
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Username or Password is empty", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        this._loginView.setRegisterLink(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                _viewManager.changeView(Views.Register);
            }
        });
    }

}
