package springboot.clasedos.hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.clasedos.hello.dto.HelloRequestDTO;
import springboot.clasedos.hello.dto.HelloResponseDTO;
import springboot.clasedos.hello.handler.HelloHandler;

import javax.validation.Valid;

@RestController
public class HelloController {
  @GetMapping("/hello/{name}")
  public String hello(@PathVariable String name) {
    return "hola" + name;
  }

  @GetMapping("/helloDTO/{name}")
  public HelloResponseDTO hellodto(@PathVariable String name) {
    return new HelloResponseDTO(name);
  }

  @PostMapping("/helloPost")
  public ResponseEntity<HelloResponseDTO> helloPost(@Valid @RequestBody HelloRequestDTO requestDTO) {
    HelloResponseDTO helloResponseDTO = new HelloResponseDTO(HelloHandler.validarHello(), HelloHandler.saveHello());
    return new ResponseEntity<>(helloResponseDTO, HttpStatus.OK);
  }


}
