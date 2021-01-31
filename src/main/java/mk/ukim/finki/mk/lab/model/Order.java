package mk.ukim.finki.mk.lab.model;

import lombok.Data;

import javax.persistence.*;
import javax.swing.text.MutableAttributeSet;
import java.util.Optional;

@Data
@Entity
@Table(name = "ballon_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String balloonColor;
    private String balloonSize;
//    String clientName;
//    String clientAddress;
    @ManyToOne
    private User user;

    public Order(){}
    public Order(String balloonColor, String balloonSize, Optional<User> user){}
    public Order(String balloonColor, String balloonSize,User user) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.user=user;
//        this.clientName = clientName;
//        this.clientAddress = clientAddress;
//        this.orderId = (long)(Math.random()*1000);
    }
}
