package mk.ukim.finki.mk.lab.model.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class OrderNotFaund extends RuntimeException {
    public OrderNotFaund(Long id) {
        super(String.format("Order with id: %d not faund!!!",id));
    }

}
