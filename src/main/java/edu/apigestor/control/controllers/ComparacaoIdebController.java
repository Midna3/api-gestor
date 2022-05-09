package edu.apigestor.control.controllers;


import edu.apigestor.control.services.IComparacaoIdebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador da comparação do Ideb.
 *
 * @version 0.1
 */
@RestController
@RequestMapping(path = "/ideb")
public class ComparacaoIdebController {

  @Autowired
  private IComparacaoIdebService comparacaoIdebService;

  @GetMapping(path = "/region/{region}")
  public ResponseEntity<Object> idebRegion(@PathVariable("region") String region) {
    return null;
  }

  @GetMapping(path = "/country/{country}")
  public ResponseEntity<Object> idebCountry(@PathVariable("country") String country) {
    return null;
  }

  @GetMapping(path = "/state/{state}")
  public ResponseEntity<Object> idebState(@PathVariable("state") String state) {
    return null;
  }

}
