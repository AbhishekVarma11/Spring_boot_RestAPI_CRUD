package Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import lombok.Data;

import com.springBoot.RestProject.Controllers.DepartmentController;
import com.springBoot.RestProject.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	private final Logger logger=LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);
    @ExceptionHandler(DepartmentNotFound.class)
    public ResponseEntity<ErrorMessage> departmentNotFound(DepartmentNotFound exception, WebRequest wb) {
        logger.error("Handling DepartmentNotFound exception: {}", exception.getMessage());
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}

	

