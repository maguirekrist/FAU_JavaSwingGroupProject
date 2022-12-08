package view;

import view.components.Form;
import view.components.ImageFileChooser;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Optional;

public class RegisterView extends Form {
    private JLabel _nameLabel;
    private JTextField _nameInput;
    private JLabel _passwordLabel;
    private JTextField _passwordInput;
    private JLabel _formError;
    private JButton _registerButton;

    private JCheckBox _typeCheckbox;

    public RegisterView() {
        super("Register");
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

        _typeCheckbox = new JCheckBox("Sign up as a seller?");

        addComponentToForm(_typeCheckbox);


        _formError = new JLabel();
        _formError.setVisible(false);

        addComponentToForm(_formError);

        _registerButton = new JButton("Register");

        _formGrid.ipady = 10;
        _formGrid.gridheight = 40;
        _formGrid.weighty = 20;
        _formGrid.fill = GridBagConstraints.HORIZONTAL;

        addComponentToForm(_registerButton);
    }

    public String getUsername() {
        return _nameInput.getText();
    }

    public String getPassword() {
        return _passwordInput.getText();
    }

    public boolean isSeller() { return _typeCheckbox.isSelected(); }

    public void assignRegistrationAction(ActionListener e) {
       _registerButton.addActionListener(e);
    }

    public void toggleFormError() {
        _formError.setText("Invalid username or password");
        _formError.setForeground(Color.RED);
        _formError.setVisible(true);
    }
}
