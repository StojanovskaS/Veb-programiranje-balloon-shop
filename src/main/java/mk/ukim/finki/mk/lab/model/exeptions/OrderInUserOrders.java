package mk.ukim.finki.mk.lab.model.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class OrderInUserOrders  extends RuntimeException{
    public OrderInUserOrders(String name,Long id) {
        super(String.format("Order in user:%s with id: %d not faund!!!",name,id));
    }

}
