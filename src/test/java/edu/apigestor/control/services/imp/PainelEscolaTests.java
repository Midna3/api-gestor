package edu.apigestor.control.services.imp;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.apigestor.data.repository.AFDRepository;
import edu.apigestor.data.repository.CensoRepository;
import edu.apigestor.data.repository.ICGRepository;
import edu.apigestor.data.repository.IDEBRepository;
import edu.apigestor.data.repository.IEDRepository;
import edu.apigestor.data.repository.IRDRepository;
import edu.apigestor.data.repository.TDIRepository;
import edu.apigestor.entity.response.HomeDadosResponse;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

public class PainelEscolaTests {
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
  @Mock
  private CensoRepository censoRepository;

  @InjectMocks
  private PainelEscola panel;

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

}
