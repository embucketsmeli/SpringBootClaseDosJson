package springboot.clasedos.edad.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Component
public class YearValidator implements Validator {
  @Override
  public boolean supports(Class<?> aClass) {
    return Integer.class.isAssignableFrom(aClass);
  }

  @Override
  public void validate(Object o, Errors errors) {
    if (errors.getErrorCount() == 0) {
      int year = (int) o;
      LocalDate now = LocalDate.now();
      if (now.getYear() < year){
        errors.reject("La fecha no puede ser mayor a la fecha actual");
      }
    }
  }
}
