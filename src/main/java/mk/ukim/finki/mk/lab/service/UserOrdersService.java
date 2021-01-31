package mk.ukim.finki.mk.lab.service;

import mk.ukim.finki.mk.lab.model.Order;
//import mk.ukim.finki.mk.lab.model.Orders;
import mk.ukim.finki.mk.lab.model.ShoppingCart;
import org.aspectj.weaver.ast.Or;
import mk.ukim.finki.mk.lab.model.User;


import java.util.List;

public interface UserOrdersService {
        List<Order> listAllOrdersinUserOrders(Long id);
        ShoppingCart getActiveUserOrder(Long id);
        ShoppingCart addProductToOrder(String username, Long orderId);
//        ShoppingCart addProductToOrder(User user, Long orderId);
}
