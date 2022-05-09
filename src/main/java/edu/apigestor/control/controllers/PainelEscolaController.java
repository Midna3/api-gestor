package edu.apigestor.control.controllers;


import edu.apigestor.control.services.IPainelEscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
  public ResponseEntity<Object> dataSchool(@PathVariable("codINEP") int codINEP) {
    return null;
  }

}
