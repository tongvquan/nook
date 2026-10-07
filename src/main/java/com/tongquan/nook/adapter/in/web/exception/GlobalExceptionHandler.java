package com.tongquan.nook.adapter.in.web.exception;

import com.tongquan.nook.adapter.in.web.dto.common.ApiResponse;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    /**
     * Handle all other unexpected exceptions
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception ex) {
        log.error("Unexpected exception occurred: {}", ex.getMessage(), ex);

        ApiResponse<Void> error = ApiResponse.error(ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiResponse<Void>> handleBadCredentialsException(BadCredentialsException ex, Locale locale) {
        log.error("Login fail");

        String message = messageSource.getMessage("auth.login.failed", null, locale);

        ApiResponse<Void> error = ApiResponse.error(message);

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleUsernameNotFoundException(
            UsernameNotFoundException ex, Locale locale) {
        log.error("Login fail");

        String message = messageSource.getMessage("auth.login.failed", null, locale);

        ApiResponse<Void> error = ApiResponse.error(message);

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiResponse<Void>> handleJwtException(JwtException ex, Locale locale) {
        log.error("Login fail");

        String message = messageSource.getMessage("auth.login.failed", null, locale);

        ApiResponse<Void> error = ApiResponse.error(message);

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
}
