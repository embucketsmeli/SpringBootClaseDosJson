package springboot.clasedos.edad.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculadoraEdadTestHttp {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void calcularEdad() {
    int expectedEdad = 28;
    Assertions.assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/calcularedad/1993/5/22",
            Integer.class), expectedEdad);
  }
}
