//package mk.ukim.finki.mk.lab.repository.inmemory;
//
//import mk.ukim.finki.mk.lab.bootstrap.DataHolder;
//import mk.ukim.finki.mk.lab.model.Order;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class OrderRepository {
//    public List<Order> findAll(){
//        return DataHolder.orders;
//    }
//    public Optional<Order> findOrderById(Long id){
//        return DataHolder.orders.stream().filter(i->i.getOrderId().equals(id)).findFirst();
//    }
//    public Optional<Order> findByName(String name){
//        return DataHolder.orders.stream().filter(i->i.getClientName().equals(name)).findFirst();
//    }
//    public Order save(String balloonColor, String balloonSize, String clientName, String clientAddress){
//        Order order=new Order(balloonColor,balloonSize,clientName,clientAddress);
//        DataHolder.orders.add(order);
//        return order;
//    }
//}
