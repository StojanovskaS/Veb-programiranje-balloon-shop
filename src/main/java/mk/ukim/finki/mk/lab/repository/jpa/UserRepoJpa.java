package mk.ukim.finki.mk.lab.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import mk.ukim.finki.mk.lab.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepoJpa extends JpaRepository<User,Long> {
    Optional<User> findByName(String text);
    Optional<User>findByNameAndPassword(String name,String password);
}
