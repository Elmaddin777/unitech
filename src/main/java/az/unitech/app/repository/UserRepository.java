package az.unitech.app.repository;

import az.unitech.app.domain.User;
import java.util.Optional;

public interface UserRepository {

    void saveUser (User user);

    Optional<User> getUserByPin(String pinCode);

}
