package edu.apigestor.control.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import edu.apigestor.control.services.IHomeService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(HomeController.class)
public class HomeControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private IHomeService homeService;

  @ParameterizedTest
  @CsvSource(value = {
      "brazil, 2010",
      "Brasil, 2017",
      "Japão, 2014",
      "Holanda, 2018",
      "EUA, 2020",
      "Brazil, null"},
      nullValues = "null")
  public void dataCountryInputTest(String country, Integer year) throws Exception {
    String getURL = (year == null) ? "/home/country/%s" : "/home/country/%s?year=%d";
    getURL = getURL.formatted(country, year);

    this.dataInputTest(country, year, getURL, Level.COUNTRY);
  }

  @ParameterizedTest
  @CsvSource(value = {
      "Centro-Oeste, 2015",
      "sudeste, 2018",
      "SUL, 2019",
      "nordeste, 2017",
      "CO, 2020",
      "NORTE, null"},
      nullValues = "null")
  public void dataRegionInputTest(String region, Integer year) throws Exception {
    String getURL = (year == null) ? "/home/region/%s" : "/home/region/%s?year=%d";
    getURL = getURL.formatted(region, year);

    this.dataInputTest(region, year, getURL, Level.REGION);
  }

  private void dataInputTest(String target, Integer year,
      String getMapping, Level level) throws Exception {
    this.mockMvc.perform(get(getMapping))
        .andDo(print());

    ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<Integer> intCaptor = ArgumentCaptor.forClass(Integer.class);

    switch (level) {
      case COUNTRY -> verify(this.homeService).dataCountry(stringCaptor.capture(),
          intCaptor.capture());
      case REGION -> verify(this.homeService).dataRegion(stringCaptor.capture(),
          intCaptor.capture());
    }

    assertEquals(target, stringCaptor.getValue());
    if (year == null) {
      assertNotNull(intCaptor.getValue());
    } else {
      assertEquals(year, intCaptor.getValue());
    }
  }

  private enum Level {
    COUNTRY, REGION
  }
}
