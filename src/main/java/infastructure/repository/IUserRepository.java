package infastructure.repository;

import infastructure.IRepository;
import model.User;

import java.util.Optional;

public interface IUserRepository extends IRepository<User> {

    Optional<User> findByUsername(String username);

    boolean isValidLogin(String username, String password);
}
