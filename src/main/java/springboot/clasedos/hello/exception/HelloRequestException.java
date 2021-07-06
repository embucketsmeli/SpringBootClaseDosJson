package springboot.clasedos.hello.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class HelloRequestException {

  @ExceptionHandler
  @ResponseBody
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorMessage errorMessage(MethodArgumentNotValidException exception) {
    BindingResult result = exception.getBindingResult();
    List<FieldError> fieldErrors = result.getFieldErrors();
    return proccessField(fieldErrors);
  }

  public ErrorMessage proccessField(List<FieldError> fieldErrors) {
    HashMap<String, String> fields = new HashMap<>();
    for (FieldError fieldError : fieldErrors) {
      fields.put(fieldError.getField(), fieldError.getDefaultMessage());
    }
    return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), "Validations Failed", fields);
  }

}
