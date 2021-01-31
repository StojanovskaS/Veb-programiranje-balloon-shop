package mk.ukim.finki.mk.lab.model.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundExceptionWithUsername extends RuntimeException {
    public UserNotFoundExceptionWithUsername(String id) {
        super(String.format("User  with name: %s not faund!!!",id));
    }

}

