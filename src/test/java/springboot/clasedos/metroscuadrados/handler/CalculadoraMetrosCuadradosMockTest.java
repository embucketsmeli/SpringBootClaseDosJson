package springboot.clasedos.metroscuadrados.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import springboot.clasedos.metroscuadrados.model.Casa;
import springboot.clasedos.metroscuadrados.model.Habitacion;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest//instanciate the web layer
//@WebMvcTest(CalculadoraEdadController.class)//instanciate only this controller instead of whole web layer
@AutoConfigureMockMvc
public class CalculadoraMetrosCuadradosMockTest {

  Casa casa;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    casa = new Casa("mansion", "Palermo", List.of(
            new Habitacion("sala", 4, 6),
            new Habitacion("comedor", 3, 3),
            new Habitacion("cocina", 2, 4),
            new Habitacion("baño", 2, 3),
            new Habitacion("cuarto", 4, 5))
    );
  }

  @Test
  public void calcularValor() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
            .post("/metroscuadrados")
            .content(asJsonString(casa))
            .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.metrosTotales").value(67));
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
