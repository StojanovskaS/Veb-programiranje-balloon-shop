//package mk.ukim.finki.mk.lab.model;
//
//import lombok.Data;
//import mk.ukim.finki.mk.lab.model.enumerations.OrdersStatus;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//@Data
//@Entity
//public class Orders {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private LocalDateTime dateCreated;
//    private OrdersStatus status;
//    @ManyToOne
//    private User user;
//    private List<Order> orders;
//    public Orders(){}
//    public Orders(User user) {
//        this.user = user;
//        this.status=OrdersStatus.CREATED;
//        this.orders=new ArrayList<>();
//        this.dateCreated=LocalDateTime.now();
////        this.id=(long)(Math.random()*1000);
//
//    }
//}
