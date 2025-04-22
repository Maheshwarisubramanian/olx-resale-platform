package com.olx.resale.app.exception;

import com.olx.resale.app.payload.ApiError;
import com.olx.resale.app.exception.GeneralException;
import com.olx.resale.app.exception.InvalidProductException;
import com.olx.resale.app.exception.ProductAlreadyExistsException;
import com.olx.resale.app.exception.ProductNotFoundException;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        ApiError apiError = new ApiError();
        apiError.setStatusCode(HttpStatus.CONFLICT.value());
        apiError.setStatus(HttpStatus.CONFLICT);
        apiError.setMessage(exception.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiError> handleUsernameNotFoundException(UsernameNotFoundException exception) {
        ApiError apiError = new ApiError();
        apiError.setStatusCode(HttpStatus.NOT_FOUND.value());
        apiError.setStatus(HttpStatus.NOT_FOUND);
        apiError.setMessage(exception.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult().getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
        ApiError error = new ApiError();
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Input Validation Error");
        error.setSubError(errors);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> handleAuthenticationException(AuthenticationException exception) {
        ApiError error = new ApiError();
        error.setStatus(HttpStatus.UNAUTHORIZED);
        error.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiError> handleJwtException(JwtException exception) {
        ApiError error = new ApiError();
        error.setStatus(HttpStatus.UNAUTHORIZED);
        error.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
    
    
    
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<?> handleProductAlreadyExistsException(ProductAlreadyExistsException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidProductException.class)
    public ResponseEntity<?> handleInvalidProductException(InvalidProductException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<?> handleGeneralException(GeneralException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
    
    
    
    
    
    
    
    

}
