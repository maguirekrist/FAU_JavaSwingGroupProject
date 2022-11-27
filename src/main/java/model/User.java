package model;


public class User extends Entity {

    private final String username;
    private final String password;
    private final UserType userType;
    private boolean validLogin;

    public User(String username, String password, UserType type) {
        super();
        this.username = username;
        this.password = password;
        this.userType = type;
    }

    public boolean isValidLogin() {
        return validLogin;
    }

    public void setValidLogin(boolean validLogin) {
        this.validLogin = validLogin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }
}
