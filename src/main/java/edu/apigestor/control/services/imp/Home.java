package edu.apigestor.control.services.imp;

import edu.apigestor.control.services.IHomeService;
import edu.apigestor.data.repository.AFDRepository;
import edu.apigestor.data.repository.ICGRepository;
import edu.apigestor.data.repository.IEDRepository;
import edu.apigestor.data.repository.IRDRepository;
import edu.apigestor.data.repository.TDIRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
