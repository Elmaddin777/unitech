package az.unitech.app.error.handler;

import az.unitech.app.error.UserAlreadyExistsException;
import az.unitech.app.error.response.ErrorCode;
import az.unitech.app.error.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({UserAlreadyExistsException.class})
    public ErrorResponse handleUserAlreadyExistsException(
            UserAlreadyExistsException ex) {
        return new ErrorResponse(ErrorCode.USER_EXISTS_ERROR, ex.getMessage());
    }

    // Other handlers can be added later

}
