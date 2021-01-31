package mk.ukim.finki.mk.lab.service.Impl;

import mk.ukim.finki.mk.lab.model.Order;
//import mk.ukim.finki.mk.lab.repository.inmemory.UserRepository;
import mk.ukim.finki.mk.lab.model.ShoppingCart;
import mk.ukim.finki.mk.lab.model.exeptions.UserNotFoundExceptionWithUsername;
import mk.ukim.finki.mk.lab.repository.jpa.OrederRepoJpa;
import mk.ukim.finki.mk.lab.repository.jpa.UserRepoJpa;
import mk.ukim.finki.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;
import mk.ukim.finki.mk.lab.model.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrederRepoJpa orderRepository;
    private final UserRepoJpa userRepository;

    public OrderServiceImpl(OrederRepoJpa orderRepository, UserRepoJpa userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<Order> findAllOrders(String username) {
        User user = userRepository.findByName(username).orElseGet(() -> {
                    throw new UserNotFoundExceptionWithUsername(username);
                });
        return orderRepository.findAllByUser(user);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }



    @Override
    public Order save(String balloonColor, String balloonSize,String username) {
//        return orderRepository.save(new Order(balloonColor, balloonSize,user));
//        this.orderRepository.deleteByBalloonColorAndBalloonSize(balloonColor,balloonSize);
//       Optional<User> user1 = this.userRepository.findByName(username);
//       if (!this.userRepository.findByName(username).isPresent()){
//           User user=new User(username);
//           this.userRepository.save(user);
//           return this.orderRepository.save(new Order(balloonColor,balloonSize,user));
//
//       }
//        return this.orderRepository.save(new Order(balloonColor,balloonSize,user1));
//        User user = userRepository.findByName(username)
//                .orElseThrow(() -> {
//                    throw new UserNotFoundExceptionWithUsername(username);
//                });
        User user=userRepository.findByName(username).orElseGet(()->{
            return userRepository.save(new User(username));
        });

        return orderRepository.save(new Order(balloonColor, balloonSize, user));
    }

//    @Override
//    public Optional<Order> findByName(String name)
//    {
//        return orderRepository.findByName(name);
//
////        return Optional.of(orderRepository.findByName(name));
//    }
}