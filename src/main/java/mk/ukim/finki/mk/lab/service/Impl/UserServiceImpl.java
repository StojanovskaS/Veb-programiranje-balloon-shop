package mk.ukim.finki.mk.lab.service.Impl;

import mk.ukim.finki.mk.lab.model.User;
import mk.ukim.finki.mk.lab.model.enumerations.Role;
import mk.ukim.finki.mk.lab.model.exeptions.*;
//import mk.ukim.finki.mk.lab.repository.inmemory.UserRepository;
import mk.ukim.finki.mk.lab.repository.jpa.UserRepoJpa;
import mk.ukim.finki.mk.lab.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepoJpa userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepoJpa userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public Optional<User> findByName(String name) {
        return this.userRepository.findByName(name);

//        return Optional.of(this.userRepository.findByName(name));
    }

    @Override
    public User login(String username, String password) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
//            User user=new User(username,username,password);
            throw new InvalidUsercCredentialException();
        }
//        User user= userRepository.findByName(username).get();
//        return user;
        return userRepository.findByNameAndPassword(username,password).orElseThrow(InvalidUsercCredentialException::new);


    }

//    @Override
//    public User register(String username, String password,String repeatpassword, String email) {
//        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
//            throw new InvalidUsercCredentialException();
//        }
//        if(!password.equals(repeatpassword)){
//            throw new PasswordsdoNootMatchException();
//        }
//        User user=new User(username,email,password);
//        return userRepository.save(user);
//    }

    @Override
    public User register(String username, String password, String repeatPassword, String email, Role userRole) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsercCredentialException();
        if (!password.equals(repeatPassword))
            throw new PasswordsdoNootMatchException();
        if(this.userRepository.findByName(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username,passwordEncoder.encode(password),email,userRole);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByName(s).orElseThrow(()->new UserNotFoundExceptionWithUsername(s));


    }
}
