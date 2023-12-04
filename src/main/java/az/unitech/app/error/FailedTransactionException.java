package az.unitech.app.error;

public class FailedTransactionException extends RuntimeException {
    public FailedTransactionException(String message) {
        super(message);
    }
}
