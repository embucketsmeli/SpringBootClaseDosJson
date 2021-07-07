package springboot.clasedos.edad.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@Data
@Validated
public class DateDTO {
  @Min(value = 1, message = "El año debe ser mayor a uno")
  private Integer year;
  @Min(value = 1, message = "El mes debe ser mayor a uno")
  private Integer month;
  @Min(value = 1, message = "El dia debe ser mayor a uno")
  private Integer day;
}
