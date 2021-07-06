package springboot.clasedos.edad.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CalculadoraEdad {

  public static int calcularEdad(int year, int month, int day){
    LocalDate now = LocalDate.now();
    LocalDate of = LocalDate.of(year, month, day);
    return now.minusYears(of.getYear()).minusMonths(of.getMonth().getValue()).minusDays(of.getDayOfMonth()).getYear();
  }
}
