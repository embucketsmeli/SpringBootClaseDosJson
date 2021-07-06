package springboot.clasedos.metroscuadrados.dto;

import lombok.Data;
import springboot.clasedos.metroscuadrados.model.Habitacion;

import java.util.Map;

@Data
public class MetrosCuadradosResponse {
  private double metrosTotales;
  private double valorDeLaCasa;
  private Habitacion habitacionMasGrande;
  private Map<Habitacion, Double> metrosCuadradosPorHabitacion;

  public MetrosCuadradosResponse(double metrosTotales, double valorDeLaCasa, Habitacion habitacionMasGrande,
                                 Map<Habitacion, Double> metrosCuadradosPorHabitacion) {
    this.metrosTotales = metrosTotales;
    this.valorDeLaCasa = valorDeLaCasa;
    this.habitacionMasGrande = habitacionMasGrande;
    this.metrosCuadradosPorHabitacion = metrosCuadradosPorHabitacion;
  }
}
