package springboot.clasedos.metroscuadrados.handler;

import springboot.clasedos.metroscuadrados.model.Casa;
import springboot.clasedos.metroscuadrados.model.Habitacion;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculadoraMetrosCuadrados {

  private final static int VALOR_METRO_CUADRADO_DOLARES = 800;

  public static double calcularValor(Casa casa) {
    return calcularTotalMetrosCuadrados(casa) * VALOR_METRO_CUADRADO_DOLARES;
  }

  public static double calcularTotalMetrosCuadrados(Casa casa) {
    return casa.getHabitaciones().stream().mapToDouble(Habitacion::getMetrosCuadrados).sum();
  }

  public static Habitacion getHabitacionMasGrande(Casa casa) {
    return casa.getHabitaciones().stream().max(Comparator.comparingDouble(Habitacion::getMetrosCuadrados)).get();
  }

  public static Map<Habitacion, Double> calcularMetrosCaudradosPorHabitacion(Casa casa) {
    return casa.getHabitaciones().stream().collect(Collectors.toMap(entry -> entry, entry -> entry.getMetrosCuadrados()));
  }
}
