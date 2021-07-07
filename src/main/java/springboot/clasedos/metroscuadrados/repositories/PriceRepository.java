package springboot.clasedos.metroscuadrados.repositories;

import springboot.clasedos.metroscuadrados.dto.PriceDTO;

import java.util.Optional;

public interface PriceRepository {
  Optional<PriceDTO> getLocationPrice(String location);
}
