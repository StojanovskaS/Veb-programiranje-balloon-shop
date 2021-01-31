//package mk.ukim.finki.mk.lab.repository.inmemory;
//
//import mk.ukim.finki.mk.lab.bootstrap.DataHolder;
//import mk.ukim.finki.mk.lab.model.Order;
//import mk.ukim.finki.mk.lab.model.Orders;
//import mk.ukim.finki.mk.lab.model.enumerations.OrdersStatus;
//import org.springframework.stereotype.Repository;
//
//import javax.xml.crypto.Data;
//import java.util.Optional;
//@Repository
//public class UserOrdersRepository {
//    public Optional<Orders> findById(Long id){
//        return DataHolder.ordersInUser.stream().filter(i->i.getId().equals(id)).findFirst();
//    }
//    public Optional<Orders> findByUsernameAndStatus(String username, OrdersStatus status){
//        return  DataHolder.ordersInUser.stream().filter(i->i.getUser().getEmail().equals(username) && i.getStatus().equals(status)).findFirst();
//    }
//    public Orders save(Orders orderCard){
//        DataHolder.ordersInUser.removeIf(i->i.getUser().getEmail().equals(orderCard.getUser().getEmail()));
//        DataHolder.ordersInUser.add(orderCard);
//        return orderCard;
//    }
//}
