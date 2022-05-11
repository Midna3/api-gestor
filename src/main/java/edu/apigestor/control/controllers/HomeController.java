package edu.apigestor.control.controllers;

import edu.apigestor.control.services.IHomeService;
import edu.apigestor.entity.response.HomeDadosNacionalResponse;
import edu.apigestor.entity.response.HomeDadosRegionalResponse;
import edu.apigestor.entity.response.HomeDadosResponse;
import edu.apigestor.entity.response.HomeEscolaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador da home.
 *
 * @version 0.1
 */
@RestController
@RequestMapping(path = "/home")
public class HomeController {

  @Autowired
  private IHomeService homeService;

  @GetMapping(path = "/region/{region}")
  public ResponseEntity<HomeDadosRegionalResponse> dataRegion(
      @PathVariable("region") String region,
      @RequestParam(name = "year", defaultValue = "2019") int year) {
    return null;
  }

  @GetMapping(path = "/country/{country}")
  public ResponseEntity<HomeDadosNacionalResponse> dataCountry(
      @PathVariable("country") String country,
      @RequestParam(name = "year", defaultValue = "2019") int year) {
    return null;
  }

  @GetMapping(path = "/state/{state}")
  public ResponseEntity<HomeDadosResponse> dataState(
      @PathVariable("state") String state,
      @RequestParam(name = "year", defaultValue = "2019") int year) {
    return null;
  }

  @GetMapping(path = "/schools/{schoolName}")
  public ResponseEntity<HomeEscolaResponse> listSchools(
      @PathVariable("schoolName") String schoolName,
      @RequestParam(value = "limit", defaultValue = "10") int limit) {
    return null;
  }

}