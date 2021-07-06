package springboot.clasedos.edad.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CalculadoraEdadTest {

  @Test
  void calcularEdad() {
    LocalDate miEdad = LocalDate.of(1993, 5, 22);
    int result = CalculadoraEdad.calcularEdad(1993, 5, 22);
    int expected = 28;
    Assertions.assertEquals(result, expected);
  }
}