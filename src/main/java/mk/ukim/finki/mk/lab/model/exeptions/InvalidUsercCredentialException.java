package mk.ukim.finki.mk.lab.model.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class InvalidUsercCredentialException extends RuntimeException {
    public InvalidUsercCredentialException(){
        super("Invalid user credentials exception");
    }
}
