package springboot.clasedos.edad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springboot.clasedos.edad.util.CalculadoraEdad;
import springboot.clasedos.edad.validator.YearValidator;

import javax.validation.Valid;

@RestController
public class CalculadoraEdadController {

  @GetMapping("/calcularedad/{year}/{month}/{day}")
  public int calcularEdad(@PathVariable int year, @PathVariable int month, @PathVariable int day){
  return CalculadoraEdad.calcularEdad(year, month, day);
  }
}
