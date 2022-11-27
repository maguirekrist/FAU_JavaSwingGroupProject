package view;

import controller.LoginController;
import infastructure.Observer;
import model.User;
import model.UserType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JPanel implements Observer<User> {

    private JLabel warningLabel;
    private JButton loginButton;
    private JTextField usernameInput;
    private JTextField passwordInput;

    public LoginView() {
        this.warningLabel = new JLabel();

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel usernameLabel = new JLabel();
        usernameLabel.setText("Username");
        usernameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        usernameInput = new JTextField();
        usernameInput.setAlignmentX(Component.LEFT_ALIGNMENT);
        usernameInput.setMaximumSize(new Dimension(Integer.MAX_VALUE, usernameInput.getPreferredSize().height));


        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        passwordInput = new JPasswordField();
        passwordInput.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordInput.setMaximumSize(new Dimension(Integer.MAX_VALUE, passwordInput.getPreferredSize().height));

        JButton loginButton = new JButton();
        loginButton.setText("Login");
        loginButton.setMargin(new Insets(10, 10, 10, 10));
        loginButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(usernameLabel);
        panel.add(usernameInput);
        panel.add(Box.createVerticalStrut(10));
        panel.add(passwordLabel);
        panel.add(passwordInput);
        panel.add(Box.createVerticalStrut(10));
        panel.add(loginButton);
        panel.add(warningLabel);

        panel.setPreferredSize(new Dimension(400, 180));
        panel.setMaximumSize(new Dimension(400, 180));
        panel.setBorder(BorderFactory.createTitledBorder("Login"));

        this.add(panel, gbc);
    }

    public String getUsername() {
        return this.usernameInput.getText();
    }

    public String getPassword() {
        return this.passwordInput.getText();
    }

    public void attemptLogin(ActionListener e) {
        this.loginButton.addActionListener(e);
    }

    @Override
    public void update(User obj) {
        if(!obj.isValidLogin())
        {
            warningLabel.setText("Invalid username or password.");
            warningLabel.setForeground(Color.RED);
            warningLabel.setVisible(true);
        } else {
            warningLabel.setForeground(Color.GREEN);
            warningLabel.setText("Successful login.");
            warningLabel.setVisible(true);
        }
    }

    private void toggleWarning() {
        if(warningLabel.isVisible()) {
            warningLabel.setVisible(false);
        } else {

        }
    }
}
