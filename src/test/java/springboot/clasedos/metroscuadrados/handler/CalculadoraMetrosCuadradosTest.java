package springboot.clasedos.metroscuadrados.handler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springboot.clasedos.metroscuadrados.model.Casa;
import springboot.clasedos.metroscuadrados.model.Habitacion;

import java.util.List;
import java.util.Map;

class CalculadoraMetrosCuadradosTest {
  Casa casa;

  @BeforeEach
  void setUp() {
    casa = new Casa("mansion", "calle siempre viva 123", List.of(
            new Habitacion("sala", 4, 6),
            new Habitacion("comedor", 3, 3),
            new Habitacion("cocina", 2, 4),
            new Habitacion("baño", 2, 3),
            new Habitacion("cuarto", 4, 5))
    );
  }

  @Test
  void calcularValor() {
    double valorDeLaCasa = CalculadoraMetrosCuadrados.calcularValor(casa);
    Assertions.assertEquals(valorDeLaCasa, 67 * 800);
  }

  @Test
  void calcularTotalMetrosCuadrados() {
    double metrosCuadrados = CalculadoraMetrosCuadrados.calcularTotalMetrosCuadrados(casa);
    Assertions.assertEquals(metrosCuadrados, 67);
  }

  @Test
  void getHabitacionMasGrande() {
    Habitacion habitacionMasGrande = CalculadoraMetrosCuadrados.getHabitacionMasGrande(casa);
    Assertions.assertEquals(habitacionMasGrande.getNombre(), "sala");
  }

  @Test
  void calcularMetrosCaudradosPorHabitacion() {
    Map<Habitacion, Double> habitacionDoubleMap = CalculadoraMetrosCuadrados.calcularMetrosCaudradosPorHabitacion(casa);
    System.out.println(habitacionDoubleMap);
  }
}