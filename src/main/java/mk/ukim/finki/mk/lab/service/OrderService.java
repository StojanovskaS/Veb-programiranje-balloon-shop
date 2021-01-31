package mk.ukim.finki.mk.lab.service;

import mk.ukim.finki.mk.lab.model.Order;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.mk.lab.model.User;


public interface OrderService {
   List<Order> findAllOrders(String username);
   Optional<Order>findById(Long id);
   Order save(String balloonColor, String balloonSize,String username);
//   Optional<Order> findByName(String name);
}
