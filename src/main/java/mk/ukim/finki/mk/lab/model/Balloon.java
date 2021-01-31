package mk.ukim.finki.mk.lab.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Balloon {

    private String name;
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Manufacturer manufacturer;

    public Balloon(){}
    public Balloon(String name, String description) {
        this.name = name;
        this.description = description;

//        this.id=(long)(Math.random()*1000);
    }

    public Balloon(String name, String description, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
//        this.id=(long)(Math.random()*1000);
    }
}
