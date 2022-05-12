package edu.apigestor.control.services.imp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

  @Test
  public void unavailableYear() throws JsonProcessingException {
    ResponseEntity<HomeDadosNacionalResponse> response = home.dataCountry("Brazil", 2013);
    String json = mapper.writeValueAsString(response.getBody());

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertTrue(json.contains("\"error\":"));
    assertTrue(json.contains("\"status\":\"%d\"".formatted(HttpStatus.BAD_REQUEST.value())));
  }

  @Test
  public void unavailableCountry() throws JsonProcessingException {
    ResponseEntity<HomeDadosNacionalResponse> response = home.dataCountry("Holanda", 2018);
    String json = this.mapper.writeValueAsString(response.getBody());

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertTrue(json.contains("\"error\":"));
    assertTrue(json.contains("\"status\":\"%d\"".formatted(HttpStatus.BAD_REQUEST.value())));
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
    String json = this.mapper.writeValueAsString(response.getBody());
    ObjectNode root = (ObjectNode) this.mapper.readTree(json);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertTrue(json.contains("\"data\":"));
    assertTrue(json.contains("\"type\":\"eduData\""));
    assertTrue(json.contains("\"id\":"));
    assertTrue(json.contains("\"attributes\":"));

    assertEquals(1.0, root.findValue("ied").findValue("mean").asDouble());
    assertEquals(1.5, root.findValue("ird").findValue("mean").asDouble());
    assertEquals(88.0, root.findValue("tdi").findValue("mean").asDouble());
    assertEquals(1.5, root.findValue("ird").findValue("mean").asDouble());
    assertEquals(6.0, root.findValue("icg").findValue("mean").asDouble());
    assertEquals(3.0, root.findValue("afd").findValue("mean").asDouble());
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
    String json = this.mapper.writeValueAsString(response.getBody());
    ObjectNode root = (ObjectNode) this.mapper.readTree(json);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertTrue(json.contains("\"data\":"));
    assertTrue(json.contains("\"type\":\"eduData\""));
    assertTrue(json.contains("\"id\":"));
    assertTrue(json.contains("\"attributes\":"));

    assertTrue(root.findValue("ied").findValue("mean").isNull());
    assertTrue(root.findValue("ird").findValue("mean").isNull());
    assertTrue(root.findValue("tdi").findValue("mean").isNull());
    assertTrue(root.findValue("ird").findValue("mean").isNull());
    assertTrue(root.findValue("icg").findValue("mean").isNull());
    assertTrue(root.findValue("afd").findValue("mean").isNull());
  }
}