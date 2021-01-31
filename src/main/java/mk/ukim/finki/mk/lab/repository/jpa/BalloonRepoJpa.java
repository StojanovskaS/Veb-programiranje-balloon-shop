package mk.ukim.finki.mk.lab.repository.jpa;

import mk.ukim.finki.mk.lab.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalloonRepoJpa extends JpaRepository<Balloon,Long> {
    List<Balloon> findAllByName(String text);
    @Query("SELECT b FROM Balloon b WHERE b.name LIKE ?1 OR b.description LIKE ?1")
    List<Balloon> search(String keyword);
    List<Balloon> findByNameLikeAndDescriptionLike(String name,String description);
    List<Balloon> findByNameLike(String name);
    List<Balloon> findByDescriptionLike(String description);
}
