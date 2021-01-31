package mk.ukim.finki.mk.lab.repository.jpa;

import mk.ukim.finki.mk.lab.model.ShoppingCart;
import mk.ukim.finki.mk.lab.model.enumerations.OrdersStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import mk.ukim.finki.mk.lab.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCardRepoJpa extends JpaRepository<ShoppingCart,Long> {
    Optional<ShoppingCart> findByUserAndStatus(User user, OrdersStatus status);
//    Optional<ShoppingCart>findByNameAndStatus(String username,OrdersStatus status);
}
