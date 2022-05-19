package edu.apigestor.control.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import edu.apigestor.control.services.IPainelEscolaService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PainelEscolaController.class)
public class PainelEscolaControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private IPainelEscolaService iPainelEscolaService;

  @ParameterizedTest
  @CsvSource(value = {
      "13082175, 2015",
      "13082175, 2018",
      "13082175, 2019",
      "13082175, 2017",
      "13082175, 2020",
      "13082175, null"},
      nullValues = "null")
  public void dataInputTest(int codINEP, Integer year) throws Exception {
    String getURL = (year == null) ? "/panel/school/%s" : "/panel/school/%s?year=%d";
    getURL = getURL.formatted(codINEP, year);

    this.mockMvc.perform(get(getURL)).andDo(print());

    ArgumentCaptor<Integer> codeCaptor = ArgumentCaptor.forClass(Integer.class);
    ArgumentCaptor<Integer> yearCaptor = ArgumentCaptor.forClass(Integer.class);

    verify(this.iPainelEscolaService).dataEscola(codeCaptor.capture(), yearCaptor.capture());

    assertEquals(codINEP, codeCaptor.getValue());
    if (year == null) {
      assertNotNull(yearCaptor.getValue());
    } else {
      assertEquals(year, yearCaptor.getValue());
    }
  }

}
