package model;


public class User extends Entity {

    private final String username;
    private final String password;
    private final UserType userType;

    public User(String username, String password, UserType type) {
        super();
        this.username = username;
        this.password = password;
        this.userType = type;
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
