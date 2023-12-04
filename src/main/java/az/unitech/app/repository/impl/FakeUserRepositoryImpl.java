package az.unitech.app.repository.impl;

import az.unitech.app.domain.User;
import az.unitech.app.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class FakeUserRepositoryImpl implements UserRepository {


    @Override
    public Optional<User> getUserByPin(String pinCode) {
        return getUsers().stream()
                .filter(user -> user.getPinCode().equals(pinCode))
                .findFirst();
    }

    private List<User> getUsers(){

        return List.of(
                new User(
                        "12345AB",
                        "John Doe",
                       "password"
                      ),

                new User(
                        "12345CD",
                        "Jane Doe",
                        "password"
                )
        );
    }

    @Override
    public void saveUser(User user) {
        //
        log.info("User saved");
    }

}
