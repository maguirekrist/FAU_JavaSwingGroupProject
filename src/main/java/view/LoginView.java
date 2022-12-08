package view;

import controller.LoginController;
import infastructure.Observer;
import model.User;
import model.UserType;
import view.components.Form;
import view.utility.LinkLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView extends Form {

    private JLabel _nameLabel;
    private JTextField _nameInput;
    private JLabel _passwordLabel;
    private JTextField _passwordInput;
    private JLabel _formError;
    private JButton _loginButton;

    private JLabel _registerLabel;

    private JLabel _registerLink;

    public LoginView() {
        super("Login");
    }

    @Override
    public void constructForm() {
        _nameLabel = new JLabel("Name");
        _nameInput = new JTextField();
        _nameLabel.setLabelFor(_nameInput);

        addComponentToForm(_nameLabel);
        addComponentToForm(_nameInput);

        _passwordLabel = new JLabel("Password");
        _passwordInput = new JPasswordField();

        addComponentToForm(_passwordLabel);
        addComponentToForm(_passwordInput);

        _formError = new JLabel();
        _formError.setVisible(false);

        addComponentToForm(_formError);

        _registerLabel = new JLabel("Don't have an account?");

        addComponentToForm(_registerLabel);

        _registerLink = new JLabel("Register.");
        _registerLink.addMouseListener(new LinkLabel());

        addComponentToForm(_registerLink);

        _loginButton = new JButton("Login");

        _formGrid.ipady = 10;
        _formGrid.gridheight = 40;
        _formGrid.weighty = 20;
        _formGrid.fill = GridBagConstraints.HORIZONTAL;

        addComponentToForm(_loginButton);
    }

    public String getUsername() {
        return this._nameInput.getText();
    }

    public String getPassword() {
        return this._passwordInput.getText();
    }

    public void attemptLogin(ActionListener e) {
        this._loginButton.addActionListener(e);
    }

    public void setRegisterLink(MouseAdapter e) { this._registerLink.addMouseListener(e);}

    public void toggleFormError() {
        _formError.setText("Invalid username or password");
        _formError.setForeground(Color.RED);
        _formError.setVisible(true);
    }
}
