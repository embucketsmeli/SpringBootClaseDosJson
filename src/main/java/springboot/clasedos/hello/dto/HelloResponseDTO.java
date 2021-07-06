package springboot.clasedos.hello.dto;

import lombok.Data;

public @Data
class HelloResponseDTO {
  private String name;

  public HelloResponseDTO(String name) {
    this.name = name;
  }


  public HelloResponseDTO(String name, String saveHello) {
    this.name = name;
  }
}
