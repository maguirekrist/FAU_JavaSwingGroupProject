package infastructure.repository;

import com.google.gson.reflect.TypeToken;
import infastructure.JsonRepository;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class UserRepository extends JsonRepository<User>  implements IUserRepository {

    public UserRepository(String className, TypeToken<ArrayList<User>> entity) throws IOException {
        super(className, entity);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return super.list().stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

    @Override
    public boolean isValidLogin(String username, String password) {
        var user = findByUsername(username);
        if(user.isPresent()) {
            if(user.get().getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
