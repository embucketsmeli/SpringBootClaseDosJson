package springboot.clasedos.edad.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import springboot.clasedos.edad.controller.CalculadoraEdadController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest//instanciate thw web layer
@WebMvcTest(CalculadoraEdadController.class)//instanciate only this controller instead of whole web layer
@AutoConfigureMockMvc
public class CalcularEdadTestMock {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void calcularEdad() throws Exception {
    String query = String.format("/calcularedad/%d/%d/%d", 1993, 5, 22);
    this.mockMvc.perform(get(query)).
            andDo(print()).
            andExpect(status().isOk()).
            andExpect(content().json("28"));

  }
}
