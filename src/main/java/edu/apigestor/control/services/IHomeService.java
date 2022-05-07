package edu.apigestor.control.services;

import edu.apigestor.entity.response.HomeDadosNacionalResponse;
import edu.apigestor.entity.response.HomeDadosRegionalResponse;
import org.springframework.http.ResponseEntity;

public interface IHomeService {

  ResponseEntity<HomeDadosRegionalResponse> dataForRegion(String region, String country);

  ResponseEntity<HomeDadosNacionalResponse> dataForCountry(String country);
}
