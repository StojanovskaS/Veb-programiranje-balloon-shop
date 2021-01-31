package mk.ukim.finki.mk.lab.repository.jpa;

import mk.ukim.finki.mk.lab.model.Order;
import mk.ukim.finki.mk.lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrederRepoJpa extends JpaRepository<Order,Long> {
//    Optional<Order> findByName(String text);
    void deleteByBalloonColorAndBalloonSize(String name1,String name2);

    List<Order> findAllByUser(User user);
}
