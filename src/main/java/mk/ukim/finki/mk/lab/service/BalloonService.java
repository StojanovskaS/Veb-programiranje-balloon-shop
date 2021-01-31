package mk.ukim.finki.mk.lab.service;

import mk.ukim.finki.mk.lab.model.Balloon;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String name,String desc);
    Optional<Balloon> save(String name,String description,Long idmanufacturer);
    Optional<Balloon> findById(Long id);
    void deleteById(Long id);
}
