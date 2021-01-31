package mk.ukim.finki.mk.lab.model.exeptions;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String id) {
        super(String.format("User  with name: %s already exist!!!",id));
    }

}