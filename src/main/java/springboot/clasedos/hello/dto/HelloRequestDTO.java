package springboot.clasedos.hello.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.List;

@Data
@Validated
public class HelloRequestDTO {

  @Max(message = "debe ser menor a 100", value = 100)
  @Min(message = "debe ser mayor a 10", value = 10)
  private Long id;
  @NotNull(message = "El dni no debe ser nulo")
  private String dni;

  @NotBlank(message = "el nombre no debe estar vacio")
  private String name;

  @NotEmpty(message = "la coleccion no debe estar vacio")
  private List<String> lastName;
}
