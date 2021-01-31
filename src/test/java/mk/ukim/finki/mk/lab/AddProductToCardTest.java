package mk.ukim.finki.mk.lab;

import mk.ukim.finki.mk.lab.model.Order;
import mk.ukim.finki.mk.lab.model.ShoppingCart;
import mk.ukim.finki.mk.lab.model.enumerations.Role;
import mk.ukim.finki.mk.lab.model.exeptions.UserNotFoundExceptionWithUsername;
import mk.ukim.finki.mk.lab.repository.jpa.BalloonRepoJpa;
import mk.ukim.finki.mk.lab.repository.jpa.OrederRepoJpa;
import mk.ukim.finki.mk.lab.repository.jpa.ShoppingCardRepoJpa;
import mk.ukim.finki.mk.lab.repository.jpa.UserRepoJpa;
import mk.ukim.finki.mk.lab.service.Impl.UserOrdersImpl;
import mk.ukim.finki.mk.lab.service.OrderService;
import mk.ukim.finki.mk.lab.service.UserOrdersService;
import mk.ukim.finki.mk.lab.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import mk.ukim.finki.mk.lab.model.User;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AddProductToCardTest {
    @Mock
    private  ShoppingCardRepoJpa userOrdersRepository;
    @Mock
    private  UserRepoJpa userRepository;
    @Mock
    private  OrederRepoJpa orderRepository;
    @Mock
    private  BalloonRepoJpa balloonRepoJpa;
    @Mock
    UserService userService;
    @Mock
    private OrderService orderService;


    private UserOrdersService service;

    private  User u1;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        User user = new User("stojanovskas","ss","stojanovska.s", Role.ROLE_ADMIN);
//        Mockito.when(this.userRepository.save(Mockito.any(User.class))).thenReturn(user);
        ShoppingCart card=new ShoppingCart(user);
//        Mockito.when(this.userOrdersRepository.save(Mockito.any(ShoppingCart.class))).thenReturn(card);
        Order order=new Order("bla","bla",user);
//        Mockito.when(this.userOrdersRepository.save(Mockito.any(ShoppingCart.class))).thenReturn(card);


        this.service = Mockito.spy(new UserOrdersImpl(userOrdersRepository,userRepository,orderRepository,balloonRepoJpa));
    }
    @Test
    public void testSuccessfullSaveOrder() {
        User user=userService.register("stojanovskas","ss","ss","stojanovska.s",Role.ROLE_ADMIN);
        Mockito.verify(this.userService).register("stojanovskas", "ss", "ss", "stojanovska.s",Role.ROLE_ADMIN);
        Order order=orderService.save("bla","bla","stojanovskas");
//        ShoppingCart cart=new ShoppingCart(user);
        Mockito.verify(this.orderService).save("bla","bla","stojanovskas");
//        ShoppingCart cart=this.service.addProductToOrder("stojanovskas",order.getOrderId());
//        Mockito.verify(this.service).addProductToOrder("stojanovskas",order.getOrderId());

//        Assert.assertNotNull("User is null", user);



    }
    @Test
    public void testUserNotInDataBase() {
        String username = "username";
        Order order=new Order("red","red ballon desc",userRepository.findByName("username"));
        Assert.assertThrows("User not found",
                UserNotFoundExceptionWithUsername.class,
                () -> this.service.addProductToOrder("bla",order.getOrderId()));
        Mockito.verify(this.service).addProductToOrder("bla",order.getOrderId());
    }

}
