package springboot.clasedos.hello.dto;

import lombok.Data;

import java.time.LocalDateTime;

public @Data
class Person {
  private String name;
  private String apellido;
  private int edad;
  private LocalDateTime fechaNacimiento;
}
