package infastructure;

import com.google.gson.reflect.TypeToken;
import model.Product;
import model.ShoppingCart;
import model.User;
import model.UserType;

import java.io.IOException;

/**
 * User session singleton, keeps a single instance of the active user and their cart
 */
public class UserSession extends Observable {

    private User _sessionUser;

    private IRepository<Product> _sessionCart;

    private static UserSession _session = null;

    private UserSession(User user) {
        this._sessionUser = user;
    }

    public User getUser() {
        return this._sessionUser;
    }

    public IRepository<Product> getCart() {
        return this._sessionCart;
    }

    public static UserSession getSession() {
        if (_session != null) {
            return _session;
        } else {
            _session = new UserSession(null);
            return _session;
        }
    }

    public boolean isAuthenticated() {
        return _sessionUser != null;
    }

    public void signIn(User user) {
        _sessionUser = user;
        if(user != null && user.getUserType() == UserType.CUSTOMER) {
            try {
                _sessionCart = new JsonRepository<>(user.getUsername() + "_cart", new TypeToken<>(){});
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.notifyObservers();
    }

    public void signOut() {
        _sessionUser = null;
        _sessionCart = null;
        this.notifyObservers();
    }

}
