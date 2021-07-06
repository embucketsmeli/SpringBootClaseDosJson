package springboot.clasedos.metroscuadrados.handler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculadoraMetrosCuadradosHttpTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

//  @Test
//  public void
}
