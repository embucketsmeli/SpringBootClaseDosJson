package springboot.clasedos.edad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class CalculadoraEdadRequestException {
  @ExceptionHandler
  @ResponseBody
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public CalcularEdadErrorMessage errorMessage(MethodArgumentNotValidException exception) {
    BindingResult result = exception.getBindingResult();
    List<FieldError> fieldErrors = result.getFieldErrors();
    return proccessField(fieldErrors);
  }

  @ExceptionHandler
  @ResponseBody
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public CalcularEdadErrorMessage errorMessage(BindException exception) {
    BindingResult result = exception.getBindingResult();
    List<FieldError> fieldErrors = result.getFieldErrors();
    return proccessField(fieldErrors);
  }

  public CalcularEdadErrorMessage proccessField(List<FieldError> fieldErrors) {
    Map<String, String> fields = fieldErrors.stream().collect(Collectors.toMap(error -> error.getField(), error -> error.getDefaultMessage()));
    return new CalcularEdadErrorMessage(HttpStatus.BAD_REQUEST.value(), "Validations Failed", fields);
  }
}
