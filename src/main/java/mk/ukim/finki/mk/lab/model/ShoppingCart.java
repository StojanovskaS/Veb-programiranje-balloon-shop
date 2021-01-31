package mk.ukim.finki.mk.lab.model;

import lombok.Data;
import mk.ukim.finki.mk.lab.model.enumerations.OrdersStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@Table(name = "ballon_shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private LocalDateTime dateCreated;
    @ManyToMany
    private List<Order> orders;
    private OrdersStatus status;
    public ShoppingCart(){}
    public ShoppingCart(User user) {
        this.user = user;
        this.status=OrdersStatus.CREATED;
        this.orders=new ArrayList<>();
        this.dateCreated=LocalDateTime.now();
//        this.user = user;
    }
}
