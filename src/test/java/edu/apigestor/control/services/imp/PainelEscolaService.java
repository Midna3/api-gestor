package edu.apigestor.control.services.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.apigestor.data.repository.AFDRepository;
import edu.apigestor.data.repository.CensoRepository;
import edu.apigestor.data.repository.ICGRepository;
import edu.apigestor.data.repository.IDEBRepository;
import edu.apigestor.data.repository.IEDRepository;
import edu.apigestor.data.repository.IRDRepository;
import edu.apigestor.data.repository.TDIRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class PainelEscolaService {
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
  private PainelEscolaService panel;

}
