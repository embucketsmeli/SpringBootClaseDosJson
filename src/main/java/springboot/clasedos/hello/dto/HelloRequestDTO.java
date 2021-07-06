package springboot.clasedos.hello.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.List;

@Data
@Validated
public class HelloRequestDTO {

  @Max(message = "menor a 100", value = 100)
  @Min(message = "mayor a 10", value = 10)
  private Long id;
  @NotNull(message = "El dni es nulo")
  private String dni;

  @NotBlank(message = "el nombre es vacio")
  private String name;

  @NotEmpty(message = "la coleccion esta vacio")
  private List<String> lastName;
}
