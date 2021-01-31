package mk.ukim.finki.mk.lab.service;

import mk.ukim.finki.mk.lab.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    public List<Manufacturer> findAll();

    Manufacturer save(String name,String contry,String address);
}
