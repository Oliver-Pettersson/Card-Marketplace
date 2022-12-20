package com.markteplace.core.exceptionhandler;


import com.markteplace.core.error.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({RecipeManagerError.class, InvalidStringException.class,
            MandatoryFieldIsNullException.class, NotFoundException.class, InvalidNumberException.class, RatingAlreadyExistsException.class,
            InvalidListException.class, UnauthorizedAccessException.class})
    public ResponseEntity<String> notFoundException(RecipeManagerError e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}

