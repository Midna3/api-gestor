package edu.apigestor.control.services.imp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.apigestor.data.repository.AFDRepository;
import edu.apigestor.data.repository.ICGRepository;
import edu.apigestor.data.repository.IDEBRepository;
import edu.apigestor.data.repository.IEDRepository;
import edu.apigestor.data.repository.IRDRepository;
import edu.apigestor.data.repository.TDIRepository;
import edu.apigestor.entity.domain.AFD;
import edu.apigestor.entity.domain.ICG;
import edu.apigestor.entity.domain.IED;
import edu.apigestor.entity.domain.IRD;
import edu.apigestor.entity.domain.TDI;
import edu.apigestor.entity.response.HomeDadosNacionalResponse;
import edu.apigestor.entity.response.HomeDadosRegionalResponse;
import edu.apigestor.entity.response.HomeDadosResponse;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class HomeTests {

  private final ObjectMapper mapper = new ObjectMapper();
  @Mock
  private IEDRepository iedRepository;
  @Mock
  private IRDRepository irdRepository;
  @Mock
  private TDIRepository tdiRepository;
  @Mock
  private ICGRepository icgRepository;
  @Mock
  private AFDRepository afdRepository;
  @Mock
  private IDEBRepository idebRepository;

  @InjectMocks
  private Home home;

  private static void assertErrorStructure(ObjectNode root, String titleContains) {
    assertTrue(root.findValue("error").isContainerNode());
    assertTrue(root.findValue("title").isTextual());
    assertTrue(root.findValue("status").isTextual());
    assertTrue(root.findValue("title").asText().contains(titleContains));
    assertTrue(root.findValue("status").asText().contains(
        Integer.toString(HttpStatus.BAD_REQUEST.value())));
  }

  private static void assertDataStructure(ObjectNode root) {
    assertTrue(root.findValue("data").isContainerNode());
    assertTrue(root.findValue("type").isTextual());
    assertTrue(root.findValue("id").isNumber());
    assertTrue(root.findValue("attributes").isContainerNode());
    assertTrue(root.findValue("year").isNumber());
  }

  @ParameterizedTest
  @CsvSource(value = {
      "2014",
      "2015",
      "2016",
      "2000"})
  public void unavailableYear(Integer year) throws JsonProcessingException {
    List<HomeDadosResponse> responses = new ArrayList<>();

    responses.add(this.home.dataCountry("BRASIL", year).getBody());
    responses.add(this.home.dataRegion("NORTE", year).getBody());

    for (HomeDadosResponse response : responses) {
      ObjectNode root = this.getRoot(this.toJson(response));
      HomeTests.assertErrorStructure(root, Integer.toString(year));
    }
  }

  @ParameterizedTest
  @CsvSource(value = {
      "Holanda",
      "Japão",
      "China",
      "Finlândia"})
  public void unavailableCountry(String country) throws JsonProcessingException {
    ResponseEntity<HomeDadosNacionalResponse> response = home.dataCountry(country, 2018);
    ObjectNode root = this.getRoot(this.toJson(response.getBody()));
    HomeTests.assertErrorStructure(root, country);
  }

  @ParameterizedTest
  @CsvSource(value = {
      "Centro-norte",
      "Sudoeste",
      "Noroeste",
      "Centro-sul"})
  public void unavailableRegion(String region) throws JsonProcessingException {
    ResponseEntity<HomeDadosRegionalResponse> response = this.home.dataRegion(region, 2018);
    ObjectNode root = this.getRoot(this.toJson(response.getBody()));
    HomeTests.assertErrorStructure(root, region);
  }

  @Test
  public void dataCountryFull() throws JsonProcessingException {
    when(this.iedRepository.getIEDForCountry(anyInt(), anyInt()))
        .thenReturn(new IED(2020, 0, 0, 0, 999, 0,
            "Total", "Total", 0,
            100.0, 0.0, 0.0, 0.0, 0.0,
            0.0));

    when(this.irdRepository.getIRDForCountry(anyInt(), anyInt()))
        .thenReturn(new IRD(2020, 0, 0, 0, 999, 0,
            "Total", "Total", 0, 1.5));

    when(this.tdiRepository.getTDIForCountry(anyInt(), anyInt()))
        .thenReturn(new TDI(2020, 0, 0, 0, 999, 0,
            "Total", "Total", 0, 88.0));

    when(this.icgRepository.getICGForCountry(anyInt(), anyInt()))
        .thenReturn(new ICG(2020, 0, 0, 0, 0, 0,
            "Total", "Total", 6.0, 0));

    when(this.afdRepository.getAFDForCountry(anyInt(), anyInt()))
        .thenReturn(new AFD(0, 0, 999, 0, 0, 2020,
            "Total", "Total", 0,
            20.0, 20.0, 20.0, 20.0, 20.0));

    ResponseEntity<HomeDadosNacionalResponse> response = home.dataCountry("Brazil", 2020);
    ObjectNode root = this.getRoot(this.toJson(response.getBody()));
    HomeTests.assertDataStructure(root);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(1.0, root.findValue("ied").findValue("mean").asDouble());
    assertEquals(1.5, root.findValue("ird").findValue("mean").asDouble());
    assertEquals(88.0, root.findValue("tdi").findValue("mean").asDouble());
    assertEquals(1.5, root.findValue("ird").findValue("mean").asDouble());
    assertEquals(6.0, root.findValue("icg").findValue("mean").asDouble());
    assertEquals(3.0, root.findValue("afd").findValue("mean").asDouble());
  }

  @Test
  public void dataRegionFull() throws JsonProcessingException {
    when(this.iedRepository.getIEDForRegion(anyInt(), anyInt()))
        .thenReturn(new IED(2020, 0, 0, 0, 999, 1,
            "Total", "Total", 1,
            0.0, 100.0, 0.0, 0.0, 0.0,
            0.0));

    when(this.irdRepository.getIRDForRegion(anyInt(), anyInt()))
        .thenReturn(new IRD(2020, 0, 0, 0, 999, 1,
            "Total", "Total", 1, 2.5));

    when(this.tdiRepository.getTDIForRegion(anyInt(), anyInt()))
        .thenReturn(new TDI(2020, 0, 0, 0, 999, 1,
            "Total", "Total", 1, 66.54));

    when(this.icgRepository.getICGForRegion(anyInt(), anyInt()))
        .thenReturn(new ICG(2020, 0, 0, 999, 0, 1,
            "Total", "Total", 5.0, 1));

    when(this.afdRepository.getAFDForRegion(anyInt(), anyInt()))
        .thenReturn(new AFD(0, 0, 999, 0, 1, 2020,
            "Total", "Total", 1,
            0.0, 0.0, 0.0, 0.0, 100.0));

    ResponseEntity<HomeDadosRegionalResponse> response = home.dataRegion("NORDESTE", 2020);
    ObjectNode root = this.getRoot(this.toJson(response.getBody()));
    HomeTests.assertDataStructure(root);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(2.0, root.findValue("ied").findValue("mean").asDouble());
    assertEquals(2.5, root.findValue("ird").findValue("mean").asDouble());
    assertEquals(66.54, root.findValue("tdi").findValue("mean").asDouble());
    assertEquals(2.5, root.findValue("ird").findValue("mean").asDouble());
    assertEquals(5.0, root.findValue("icg").findValue("mean").asDouble());
    assertEquals(5.0, root.findValue("afd").findValue("mean").asDouble());
  }

  @Test
  public void dataCountryEmpty() throws JsonProcessingException {
    when(this.iedRepository.getIEDForCountry(anyInt(), anyInt()))
        .thenReturn(new IED());

    when(this.irdRepository.getIRDForCountry(anyInt(), anyInt()))
        .thenReturn(new IRD());

    when(this.tdiRepository.getTDIForCountry(anyInt(), anyInt()))
        .thenReturn(new TDI());

    when(this.icgRepository.getICGForCountry(anyInt(), anyInt()))
        .thenReturn(new ICG());

    when(this.afdRepository.getAFDForCountry(anyInt(), anyInt()))
        .thenReturn(new AFD());

    ResponseEntity<HomeDadosNacionalResponse> response = home.dataCountry("Brasil", 2017);
    ObjectNode root = this.getRoot(this.toJson(response.getBody()));
    HomeTests.assertDataStructure(root);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertTrue(root.findValue("ied").findValue("mean").isNull());
    assertTrue(root.findValue("ird").findValue("mean").isNull());
    assertTrue(root.findValue("tdi").findValue("mean").isNull());
    assertTrue(root.findValue("ird").findValue("mean").isNull());
    assertTrue(root.findValue("icg").findValue("mean").isNull());
    assertTrue(root.findValue("afd").findValue("mean").isNull());
  }

  @Test
  public void dataRegionEmpty() throws JsonProcessingException {
    when(this.iedRepository.getIEDForRegion(anyInt(), anyInt()))
        .thenReturn(new IED());

    when(this.irdRepository.getIRDForRegion(anyInt(), anyInt()))
        .thenReturn(new IRD());

    when(this.tdiRepository.getTDIForRegion(anyInt(), anyInt()))
        .thenReturn(new TDI());

    when(this.icgRepository.getICGForRegion(anyInt(), anyInt()))
        .thenReturn(new ICG());

    when(this.afdRepository.getAFDForRegion(anyInt(), anyInt()))
        .thenReturn(new AFD());

    ResponseEntity<HomeDadosRegionalResponse> response = home.dataRegion("NORDESTE", 2017);
    ObjectNode root = this.getRoot(this.toJson(response.getBody()));
    HomeTests.assertDataStructure(root);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertTrue(root.findValue("ied").findValue("mean").isNull());
    assertTrue(root.findValue("ird").findValue("mean").isNull());
    assertTrue(root.findValue("tdi").findValue("mean").isNull());
    assertTrue(root.findValue("ird").findValue("mean").isNull());
    assertTrue(root.findValue("icg").findValue("mean").isNull());
    assertTrue(root.findValue("afd").findValue("mean").isNull());
  }

  private String toJson(Object object) throws JsonProcessingException {
    return this.mapper.writeValueAsString(object);
  }

  private ObjectNode getRoot(String json) throws JsonProcessingException {
    return (ObjectNode) this.mapper.readTree(json);
  }
}
