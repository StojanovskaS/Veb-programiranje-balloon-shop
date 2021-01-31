package mk.ukim.finki.mk.lab.model.exeptions;

public class PasswordsdoNootMatchException extends RuntimeException {
    public PasswordsdoNootMatchException(){
        super("Invalid user password exception");
    }

}
