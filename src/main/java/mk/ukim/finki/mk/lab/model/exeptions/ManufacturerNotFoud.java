package mk.ukim.finki.mk.lab.model.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ManufacturerNotFoud extends RuntimeException{
    public ManufacturerNotFoud(Long id) {
        super(String.format("Manufacturer with id: %d not faund!!!",id));
    }
}
