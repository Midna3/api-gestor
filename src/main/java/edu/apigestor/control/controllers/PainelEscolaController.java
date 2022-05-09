package edu.apigestor.control.controllers;


import edu.apigestor.control.services.IPainelEscolaService;
import edu.apigestor.entity.response.PainelEscolaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador do painel da escola.
 *
 * @version 0.1
 */
@RestController
@RequestMapping(path = "/panel")
public class PainelEscolaController {

  @Autowired
  private IPainelEscolaService painelEscolaService;

  @GetMapping(path = "/school/{codINEP}")
  public ResponseEntity<PainelEscolaResponse> dataSchool(
      @PathVariable("codINEP") int codINEP,
      @RequestParam(name = "year", defaultValue = "2019") int year) {
    return null;
  }

}
