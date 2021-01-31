//package mk.ukim.finki.mk.lab.repository.inmemory;
//
//import mk.ukim.finki.mk.lab.bootstrap.DataHolder;
//import mk.ukim.finki.mk.lab.model.Balloon;
//import mk.ukim.finki.mk.lab.model.Manufacturer;
//import mk.ukim.finki.mk.lab.model.exeptions.BalloonNotFound;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Repository
//public class BalloonRepository {
//
//    public List<Balloon> findAllBalloons(){
//    return DataHolder.balloonList;
//    }
//    public List<Balloon> findAllByNameOrDescription(String text){
//        return DataHolder.balloonList.stream().filter(r->r.getName().contains(text) || r.getDescription().contains(text)).collect(Collectors.toList());
//
//    }
//    //lab 2
//    public Optional<Balloon> save(String name, String description, Manufacturer manufacturer){
//        DataHolder.balloonList.removeIf(i->i.getName().equals(name));
//        Balloon balloon=new Balloon(name,description,manufacturer);
//        DataHolder.balloonList.add(balloon);
//        return Optional.of(balloon);
//    }
//    public Optional<Balloon> findById(Long id){
//        return DataHolder.balloonList.stream().filter(i->i.getId().equals(id)).findFirst();
//    }
//    public void deleteById(Long id){
//        DataHolder.balloonList.removeIf(i->i.getId().equals(id));
//
//    }
//}
