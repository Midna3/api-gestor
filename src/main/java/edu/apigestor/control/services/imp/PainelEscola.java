package edu.apigestor.control.services.imp;

import edu.apigestor.control.services.IPainelEscolaService;
import edu.apigestor.data.repository.AFDRepository;
import edu.apigestor.data.repository.ICGRepository;
import edu.apigestor.data.repository.IDEBRepository;
import edu.apigestor.data.repository.IEDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PainelEscola implements IPainelEscolaService {

  @Autowired
  private IDEBRepository idebRepository;

  @Autowired
  private IEDRepository iedRepository;

  @Autowired
  private ICGRepository icgRepository;

  @Autowired
  private AFDRepository afdRepository;

}
