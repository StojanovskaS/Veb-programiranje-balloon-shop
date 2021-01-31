package mk.ukim.finki.mk.lab.service.Impl;

import mk.ukim.finki.mk.lab.model.Balloon;
import mk.ukim.finki.mk.lab.model.Order;
//import mk.ukim.finki.mk.lab.model.Orders;
import mk.ukim.finki.mk.lab.model.ShoppingCart;
import mk.ukim.finki.mk.lab.model.User;
import mk.ukim.finki.mk.lab.model.enumerations.OrdersStatus;
import mk.ukim.finki.mk.lab.model.exeptions.OrderNotFaund;
import mk.ukim.finki.mk.lab.model.exeptions.UserNotFoundException;
import mk.ukim.finki.mk.lab.model.exeptions.UserNotFoundExceptionWithUsername;
import mk.ukim.finki.mk.lab.model.exeptions.UserOrdersExp;
//import mk.ukim.finki.mk.lab.repository.inmemory.UserRepository;
import mk.ukim.finki.mk.lab.repository.jpa.BalloonRepoJpa;
import mk.ukim.finki.mk.lab.repository.jpa.OrederRepoJpa;
import mk.ukim.finki.mk.lab.repository.jpa.ShoppingCardRepoJpa;
import mk.ukim.finki.mk.lab.repository.jpa.UserRepoJpa;
import mk.ukim.finki.mk.lab.service.UserOrdersService;
import org.springframework.jmx.export.notification.UnableToSendNotificationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserOrdersImpl implements UserOrdersService {
    private final ShoppingCardRepoJpa userOrdersRepository;
    private final UserRepoJpa userRepository;
    private final OrederRepoJpa orderRepository;
    private final BalloonRepoJpa balloonRepoJpa;

    public UserOrdersImpl(ShoppingCardRepoJpa userOrdersRepository, UserRepoJpa userRepository, OrederRepoJpa orderRepository,BalloonRepoJpa balloonRepoJpa) {
        this.userOrdersRepository = userOrdersRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.balloonRepoJpa=balloonRepoJpa;
    }


    @Override
    public List<Order> listAllOrdersinUserOrders(Long id) {
        if(!this.userOrdersRepository.findById(id).isPresent()){
            throw new UserOrdersExp(id);
        }
        return this.userOrdersRepository.findById(id).get().getOrders();
    }

    @Override
    @Transactional
    public ShoppingCart getActiveUserOrder(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        return this.userOrdersRepository.findByUserAndStatus(user, OrdersStatus.CREATED).orElseGet(() -> {
            ShoppingCart cart = new ShoppingCart(user);
            return this.userOrdersRepository.save(cart);
        });

    }

    @Override
    @Transactional
    public ShoppingCart addProductToOrder(String username, Long orderId) {
//        Optional<User> user = this.userRepository.findByName(username);
        if (!userRepository.findByName(username).isPresent()){
            throw new UserNotFoundExceptionWithUsername(username);
        }
        User user=userRepository.findByName(username).orElseThrow(()->new UserNotFoundExceptionWithUsername(username));
        ShoppingCart orderCard=this.getActiveUserOrder(user.getId());
        Order order=orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFaund(orderId));
        orderCard.getOrders().add(order);
        return this.userOrdersRepository.save(orderCard);
    }
}
