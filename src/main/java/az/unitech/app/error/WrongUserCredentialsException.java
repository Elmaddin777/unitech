package az.unitech.app.error;

public class WrongUserCredentialsException extends RuntimeException{
    public WrongUserCredentialsException(String message) {
        super(message);
    }
}
