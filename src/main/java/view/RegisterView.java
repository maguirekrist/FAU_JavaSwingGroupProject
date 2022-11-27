package view;

import view.components.ImageFileChooser;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Optional;

public class RegisterView extends JPanel {
    private int gridYLevel = 0;
    private JPanel _formPanel;
    private GridBagConstraints _formGrid;
    private JLabel _nameLabel;
    private JTextField _nameInput;
    private JLabel _passwordLabel;
    private JTextField _passwordInput;
    private JLabel _formError;
    private JButton _registerButton;

    public RegisterView() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        _formPanel = new JPanel();
        _formPanel.setLayout(new GridBagLayout());
        _formGrid = new GridBagConstraints();
        _formGrid.fill = GridBagConstraints.HORIZONTAL;
        _formGrid.gridy = 0;
        _formGrid.gridx = 0;
        _formGrid.weightx = 1;

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

        _registerButton = new JButton("Register");

        _formGrid.ipady = 10;
        _formGrid.gridheight = 40;
        _formGrid.weighty = 20;
        _formGrid.fill = GridBagConstraints.HORIZONTAL;

        addComponentToForm(_registerButton);

        _formPanel.setPreferredSize(new Dimension(400, 400));
        _formPanel.setMaximumSize(new Dimension(400, 400));
        _formPanel.setBorder(new CompoundBorder(
                BorderFactory.createTitledBorder("Register"),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        this.add(_formPanel, gbc);
    }

    public String getUsername() {
        return _nameInput.getText();
    }

    public String getPassword() {
        return _passwordInput.getText();
    }

    public void assignRegistrationAction(ActionListener e) {
       _registerButton.addActionListener(e);
    }

    public void toggleFormError() {
        _formError.setText("Invalid username or password");
        _formError.setForeground(Color.RED);
        _formError.setVisible(true);
    }

    private void addComponentToForm(JComponent c) {
        _formGrid.gridy = gridYLevel++;
        _formPanel.add(c, _formGrid);
    }
}
