package mk.ukim.finki.mk.lab.service.Impl;

import mk.ukim.finki.mk.lab.model.Manufacturer;
//import mk.ukim.finki.mk.lab.repository.inmemory.ManufacturerRepository;
import mk.ukim.finki.mk.lab.repository.jpa.ManifacturerRepoJpa;
import mk.ukim.finki.mk.lab.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManifacturerRepoJpa manufacturerRepository;

    public ManufacturerServiceImpl(ManifacturerRepoJpa manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return this.manufacturerRepository.findAll();
    }
    @Override
    public Manufacturer save(String name,String contry,String address){
        return this.manufacturerRepository.save(new Manufacturer(name,contry,address));
    }
}
