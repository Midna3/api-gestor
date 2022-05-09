package edu.apigestor.control.controllers;

import edu.apigestor.control.services.IHomeService;
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
  public ResponseEntity<Object> dataRegion(@PathVariable("region") String region) {
    return null;
  }

  @GetMapping(path = "/country/{country}")
  public ResponseEntity<Object> dataCountry(@PathVariable("country") String country) {
    return null;
  }

  @GetMapping(path = "/state/{state}")
  public ResponseEntity<Object> dataState(@PathVariable("state") String state) {
    return null;
  }

  @GetMapping(path = "/schools/{schoolName}")
  public ResponseEntity<Object> listSchools(@PathVariable("schoolName") String schoolName,
      @RequestParam(value = "limit", defaultValue = "10") int limit) {
    return null;
  }

}