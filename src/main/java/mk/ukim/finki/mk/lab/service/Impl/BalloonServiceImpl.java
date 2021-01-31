package mk.ukim.finki.mk.lab.service.Impl;

import mk.ukim.finki.mk.lab.model.Balloon;
import mk.ukim.finki.mk.lab.model.Manufacturer;
import mk.ukim.finki.mk.lab.model.exeptions.ManufacturerNotFoud;
//import mk.ukim.finki.mk.lab.repository.inmemory.BalloonRepository;
//import mk.ukim.finki.mk.lab.repository.inmemory.ManufacturerRepository;
import mk.ukim.finki.mk.lab.repository.jpa.BalloonRepoJpa;
import mk.ukim.finki.mk.lab.repository.jpa.ManifacturerRepoJpa;
import mk.ukim.finki.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {
    private final BalloonRepoJpa balloonRepository;
    private final ManifacturerRepoJpa manufacturerRepository;

    public BalloonServiceImpl(BalloonRepoJpa balloonRepository,ManifacturerRepoJpa manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository=manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAll() ;
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String name,String desc) {
        String name1="%"+name+"%";
        String desc1="%"+desc+"%";
        if (name != null && desc != null ){
            return balloonRepository.findByNameLikeAndDescriptionLike(name1,desc1);
        }else if (name != null){
            return balloonRepository.findByNameLike(name1);
        }else if (desc != null){
            return balloonRepository.findByDescriptionLike(desc1);
        }else {
            return balloonRepository.findAll();
        }
    }
// za lab 2
    @Override
    public Optional<Balloon> save(String name, String description, Long idmanufacturer) {
        Manufacturer manufacturer=this.manufacturerRepository.findById(idmanufacturer).orElseThrow(()-> new ManufacturerNotFoud(idmanufacturer));

        return Optional.of(balloonRepository.save(new Balloon(name,description,manufacturer)));
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return this.balloonRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.balloonRepository.deleteById(id);
    }
}
