//package mk.ukim.finki.mk.lab.repository.inmemory;
//
//import mk.ukim.finki.mk.lab.bootstrap.DataHolder;
//import mk.ukim.finki.mk.lab.model.User;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public class UserRepository {
//    public Optional<User> findByName(String name){
//        return DataHolder.users.stream().filter(i->i.getEmail().equals(name)).findFirst();
//    }
//}
