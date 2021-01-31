package mk.ukim.finki.mk.lab.bootstrap;

import lombok.Getter;
import mk.ukim.finki.mk.lab.model.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Balloon> balloonList=new ArrayList<>();
    public static List<Manufacturer> manufacturers=new ArrayList<>();
    public static List<Order> orders=new ArrayList<>();
    public static List<User> users=new ArrayList<>();
    public static List<ShoppingCart> ordersInUser=new ArrayList<>();
//    @PostConstruct
//    public void init(){
//        balloonList.add(new Balloon("Balloon 1 ","Desc Balloon 1"));
//        balloonList.add(new Balloon("Balloon 2 ","Desc Balloon 2"));
//        balloonList.add(new Balloon("Balloon 3 ","Desc Balloon 3"));
//        balloonList.add(new Balloon("Balloon 4 ","Desc Balloon 4"));
//        balloonList.add(new Balloon("Balloon 5 ","Desc Balloon 5"));
//
//        Manufacturer manufacturer=new Manufacturer("Grand ballons Community","Macedonia","st.Prvomajska no.45,Skopje");
//        manufacturers.add(manufacturer);
//        balloonList.add(new Balloon("Balloon 10 ","Desc Balloon 10",manufacturer));
//        balloonList.add(new Balloon("Balloon 6 ","Desc Balloon 6",manufacturer));
//        balloonList.add(new Balloon("Balloon 7 ","Desc Balloon 7",manufacturer));
//        balloonList.add(new Balloon("Balloon 8 ","Desc Balloon 8",manufacturer));
//        balloonList.add(new Balloon("Balloon 9 ","Desc Balloon 9",manufacturer));
//        balloonList.add(new Balloon("Balloon 10 ","Desc Balloon 10",manufacturer));
//
////        lab 2 del
//        manufacturers.add(new Manufacturer("Monmantre Group","France","st.Rue du Mullin,Paris"));
//        manufacturers.add(new Manufacturer("Croatia ballons","Croatia","st.Zagrebska no.05,Zagreb"));
//        manufacturers.add(new Manufacturer("Water ballons Group","USA","st.Bla bla no.04,NY"));
//        manufacturers.add(new Manufacturer("British balloons","UK","st.gg no.44,London"));
//        users.add(new User("sandra","stojanovska.s","ss"));
//        users.add(new User("bojana","stojanovska.b","bb"));
//        users.add(new User("marija","cipevskam","mm"));
//        users.add(new User("darko","darevski d","dd"));
//        orders.add(new Order("red","big","sandra","SS"));
//
//
//
//
//
//
//
//
//    }
}
