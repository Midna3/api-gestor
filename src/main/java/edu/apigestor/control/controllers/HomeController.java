package edu.apigestor.control.controllers;

import edu.apigestor.control.services.IHomeService;
import edu.apigestor.entity.response.HomeDadosNacionalResponse;
import edu.apigestor.entity.response.HomeDadosRegionalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/home")
public class HomeController {

  @Autowired
  private IHomeService homeService;

  @GetMapping(path = "/region/{region}")
  public ResponseEntity<HomeDadosRegionalResponse> dataRegion(@PathVariable("region") String region,
      @RequestParam(value = "country", defaultValue = "brazil") String country) {
    return this.homeService.dataForRegion(region, country);
  }

  @GetMapping(path = "/country/{country}")
  public ResponseEntity<HomeDadosNacionalResponse> dataCountry(
      @PathVariable("country") String country) {
    return this.homeService.dataForCountry(country);
  }

}
