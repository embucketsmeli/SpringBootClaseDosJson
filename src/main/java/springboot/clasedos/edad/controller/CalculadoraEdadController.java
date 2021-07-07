package springboot.clasedos.edad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springboot.clasedos.edad.dto.DateDTO;
import springboot.clasedos.edad.util.CalculadoraEdad;

import javax.validation.Valid;

@RestController
public class CalculadoraEdadController {

  @GetMapping("/calcularedad/{year}/{month}/{day}")
  public int calcularEdad(@Valid DateDTO dateDTO) {
    return CalculadoraEdad.calcularEdad(dateDTO.getYear(), dateDTO.getMonth(), dateDTO.getDay());
  }
}
