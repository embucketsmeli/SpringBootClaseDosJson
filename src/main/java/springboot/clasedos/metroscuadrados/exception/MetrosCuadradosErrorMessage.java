package springboot.clasedos.metroscuadrados.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class MetrosCuadradosErrorMessage {
  private Integer status;
  private String error;
  private Map<String, String> message;

  public MetrosCuadradosErrorMessage(Integer status, String error, Map<String, String> message) {
    this.status = status;
    this.error = error;
    this.message = message;
  }
}
