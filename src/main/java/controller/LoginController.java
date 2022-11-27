package controller;

import model.User;
import view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    private User user;
    private LoginView loginView;

    public LoginController(LoginView loginView, User user) {
        this.loginView = loginView;
        this.user = user;

        this.user.addObserver(this.loginView);

        this.loginView.attemptLogin(e -> {
            String username = this.loginView.getUsername();
            String password = this.loginView.getPassword();
            if(username.length() > 0 && password.length() > 0)
            {
                if(username.equals(user.getUsername()) && password.equals(user.getPassword()))
                    user.setValidLogin(true);
                else
                    user.setValidLogin(false);
                user.notifyObservers();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Username or Password is empty", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
