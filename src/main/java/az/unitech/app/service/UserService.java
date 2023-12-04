package az.unitech.app.service;

import az.unitech.app.domain.User;
import az.unitech.app.dto.LoginDto;
import az.unitech.app.dto.UserDto;
import az.unitech.app.error.UserAlreadyExistsException;
import az.unitech.app.error.WrongUserCredentialsException;
import az.unitech.app.repository.UserRepository;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    // @Transactional
    public void saveUser(UserDto userDto) {
        var user = userRepository.getUserByPin(userDto.getPinCode());

        if (user.isPresent()) {
            throw new UserAlreadyExistsException("User with this PIN already exists");
        }

        userRepository.saveUser(modelMapper.map(userDto, User.class));
        //
        log.info("User registered");
    }

    public void login(LoginDto loginDto) {
        var user = userRepository.getUserByPin(loginDto.getPinCode());

        if (user.isPresent()) {
            if (loginDto.getPassword().equals(user.get().getPassword())) {
                //
                log.info("User logged in");
            }
        } else {
            throw new WrongUserCredentialsException("Wrong credentials");
        }

    }

}
