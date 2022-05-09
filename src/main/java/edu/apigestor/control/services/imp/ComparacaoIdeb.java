package edu.apigestor.control.services.imp;

import edu.apigestor.control.services.IPainelEscolaService;
import edu.apigestor.data.repository.IDEBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComparacaoIdeb implements IPainelEscolaService {

  @Autowired
  private IDEBRepository idebRepository;

}
