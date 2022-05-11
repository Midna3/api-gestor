package edu.apigestor.control.services.imp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.apigestor.data.repository.AFDRepository;
import edu.apigestor.data.repository.ICGRepository;
import edu.apigestor.data.repository.IDEBRepository;
import edu.apigestor.data.repository.IEDRepository;
import edu.apigestor.data.repository.IRDRepository;
import edu.apigestor.data.repository.TDIRepository;
import edu.apigestor.entity.response.HomeDadosNacionalResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

  @Test
  public void unavailableYear() throws JsonProcessingException {
    Home home = new Home();
    ResponseEntity<HomeDadosNacionalResponse> response = home.dataCountry("Brazil", 2013);
    String json = mapper.writeValueAsString(response.getBody());

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertTrue(json.contains("\"error\":"));
    assertTrue(json.contains("\"status\":\"%d\"".formatted(HttpStatus.BAD_REQUEST.value())));
  }

  @Test
  public void unavailableCountry() throws JsonProcessingException {
    Home home = new Home();
    ResponseEntity<HomeDadosNacionalResponse> response = home.dataCountry("Holanda", 2018);
    String json = this.mapper.writeValueAsString(response.getBody());

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertTrue(json.contains("\"error\":"));
    assertTrue(json.contains("\"status\":\"%d\"".formatted(HttpStatus.BAD_REQUEST.value())));
  }

  @Test
  public void dataCountry() {

  }
}
