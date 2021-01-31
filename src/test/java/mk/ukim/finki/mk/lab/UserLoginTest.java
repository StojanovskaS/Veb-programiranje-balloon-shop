package mk.ukim.finki.mk.lab;

import mk.ukim.finki.mk.lab.model.exeptions.InvalidUsercCredentialException;
import mk.ukim.finki.mk.lab.repository.jpa.UserRepoJpa;
import mk.ukim.finki.mk.lab.service.Impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import mk.ukim.finki.mk.lab.model.User;


@RunWith(MockitoJUnitRunner.class)
public class UserLoginTest {

    @Mock
    private UserRepoJpa userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    private UserServiceImpl service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        User user = new User("username", "password");

        this.service = Mockito.spy(new UserServiceImpl(this.userRepository, this.passwordEncoder));
    }

    @Test
    public void testNullUsername() {
        Assert.assertThrows("InvalidArgumentException expected",
                InvalidUsercCredentialException.class,
                () -> this.service.login(null, "password"));
        Mockito.verify(this.service).login(null, "password");
    }

    @Test
    public void testEmptyUsername() {
        String username = "";
        Assert.assertThrows("InvalidArgumentException expected",
                InvalidUsercCredentialException.class,
                () -> this.service.login(username, "password"));
        Mockito.verify(this.service).login(username, "password");
    }


    @Test
    public void testEmptyPassword() {
        String username = "username";
        String password = "";
        Assert.assertThrows("InvalidArgumentException expected",
                InvalidUsercCredentialException.class,
                () -> this.service.login(username, password));
        Mockito.verify(this.service).login(username, password);
    }

    @Test
    public void testNullPassword() {
        String username = "username";
        String password = null;
        Assert.assertThrows("InvalidArgumentException expected",
                InvalidUsercCredentialException.class,
                () -> this.service.login(username, password));
        Mockito.verify(this.service).login(username, password);
    }

    @Test
    public void testInvalidUser() {
        Assert.assertThrows("InvalidUserCredentialsException expected",
                InvalidUsercCredentialException.class,
                () -> this.service.login("username", "password"));
        Mockito.verify(this.service).login("username", "password");
    }




}