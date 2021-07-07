package springboot.clasedos.metroscuadrados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springboot.clasedos.metroscuadrados.dto.MetrosCuadradosResponse;
import springboot.clasedos.metroscuadrados.handler.CalculadoraMetrosCuadrados;
import springboot.clasedos.metroscuadrados.model.Casa;

import javax.validation.Valid;

@RestController
public class MetrosCuadradosController {

  @Autowired
  CalculadoraMetrosCuadrados metrosCuadradosService;

  @PostMapping("/metroscuadrados")
  public ResponseEntity<MetrosCuadradosResponse> calcularMetrosCuadrados(@Valid @RequestBody Casa casa) {
    return new ResponseEntity<>(new MetrosCuadradosResponse(
            metrosCuadradosService.calcularTotalMetrosCuadrados(casa),
            metrosCuadradosService.calcularValor(casa),
            metrosCuadradosService.getHabitacionMasGrande(casa),
            metrosCuadradosService.calcularMetrosCaudradosPorHabitacion(casa)), HttpStatus.OK);
  }
}
