package edu.apigestor.control.services.imp;

import edu.apigestor.control.services.IHomeService;
import edu.apigestor.data.repository.AFDRepository;
import edu.apigestor.data.repository.ICGRepository;
import edu.apigestor.data.repository.IDEBRepository;
import edu.apigestor.data.repository.IEDRepository;
import edu.apigestor.data.repository.IRDRepository;
import edu.apigestor.data.repository.TDIRepository;
import edu.apigestor.entity.response.HomeDadosNacionalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class Home implements IHomeService {

  @Autowired
  private IEDRepository iedRepository;

  @Autowired
  private IRDRepository irdRepository;

  @Autowired
  private TDIRepository tdiRepository;

  @Autowired
  private ICGRepository icgRepository;

  @Autowired
  private AFDRepository afdRepository;

  @Autowired
  private IDEBRepository idebRepository;

  @Override
  public ResponseEntity<HomeDadosNacionalResponse> dataCountry(String country, int year) {
    return null;
  }
}
