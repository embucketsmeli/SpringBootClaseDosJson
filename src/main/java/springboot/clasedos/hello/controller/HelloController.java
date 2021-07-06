package springboot.clasedos.hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.clasedos.hello.dto.HelloRequestDTO;
import springboot.clasedos.hello.dto.HelloResponseDTO;

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
  public ResponseEntity<HelloResponseDTO> helloPost(@RequestBody HelloRequestDTO requestDTO) {
    return null;
  }


}
