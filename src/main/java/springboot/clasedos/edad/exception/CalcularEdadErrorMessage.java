package springboot.clasedos.edad.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class CalcularEdadErrorMessage {
  private Integer status;
  private String error;
  private Map<String, String> message;

  public CalcularEdadErrorMessage(Integer status, String error, Map<String, String> message) {
    this.status = status;
    this.error = error;
    this.message = message;
  }
}
