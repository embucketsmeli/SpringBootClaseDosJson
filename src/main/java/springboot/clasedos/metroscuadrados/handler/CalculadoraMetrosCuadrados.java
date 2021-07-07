package springboot.clasedos.metroscuadrados.handler;

import org.springframework.stereotype.Service;
import springboot.clasedos.metroscuadrados.dto.PriceDTO;
import springboot.clasedos.metroscuadrados.repositories.PriceRepository;
import springboot.clasedos.metroscuadrados.service.CalcularMetrosCuadrados;

import java.util.Optional;

@Service
public class CalculadoraMetrosCuadrados implements CalcularMetrosCuadrados {

  private final static double VALOR_METRO_CUADRADO_DOLARES = 800;
  private final PriceRepository priceRepository;

  public CalculadoraMetrosCuadrados(PriceRepository priceRepository) {
    this.priceRepository = priceRepository;
  }

  @Override
  public double getValorMetroCuadrado(String location) {
    Optional<PriceDTO> locationPrice = priceRepository.getLocationPrice(location);
    return locationPrice.isPresent() ? locationPrice.get().getPrice() : VALOR_METRO_CUADRADO_DOLARES;
  }
}
