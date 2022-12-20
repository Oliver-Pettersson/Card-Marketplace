package com.markteplace.core.exceptionhandler;

import com.markteplace.core.error.UsernameAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthControllerAdvisor {
    @ExceptionHandler({UsernameAlreadyExistsException.class})
    public ResponseEntity<String> usernameAlreadyExistsException(UsernameAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
