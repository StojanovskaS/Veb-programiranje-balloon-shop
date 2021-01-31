package mk.ukim.finki.mk.lab.model.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BalloonNotFound extends RuntimeException{
    public BalloonNotFound(Long id) {
        super(String.format("Balloon not found with id: %d !!!",id));
    }
}
