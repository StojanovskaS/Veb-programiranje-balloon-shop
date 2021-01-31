package mk.ukim.finki.mk.lab.service;

import mk.ukim.finki.mk.lab.model.User;
import mk.ukim.finki.mk.lab.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> findByName(String name);
    User login(String username, String password);
    User register(String username, String password, String repeatpassword, String email, Role role);

}
