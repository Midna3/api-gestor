package edu.apigestor.control.services.imp;

import edu.apigestor.control.mappers.AddressMapper;
import edu.apigestor.control.mappers.CategoryMapper;
import edu.apigestor.control.mappers.DependenciaMapper;
import edu.apigestor.control.services.IPainelEscolaService;
import edu.apigestor.control.utils.AvailableYears;
import edu.apigestor.control.utils.MeanUtils;
import edu.apigestor.data.repository.*;
import edu.apigestor.entity.domain.*;
import edu.apigestor.entity.response.PainelEscolaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class PainelEscola implements IPainelEscolaService {

  private final AtomicLong count = new AtomicLong();
  @Autowired
  private IEDRepository iedRepository;

  @Autowired
  private ICGRepository icgRepository;

  @Autowired
  private AFDRepository afdRepository;

  @Autowired
  private IDEBRepository idebRepository;

  @Autowired
  private CensoRepository censoRepository;

  public ResponseEntity<PainelEscolaResponse> dataEscola(int codINEP, int year){
    long responseID = count.incrementAndGet();
    PainelEscolaResponse painelEscolaResponse = new PainelEscolaResponse();

    if (!AvailableYears.isAvailable(year)){
      painelEscolaResponse.addError(responseID, HttpStatus.BAD_REQUEST.value(),
              "Year '%d' is unavailable".formatted(year));
      return new ResponseEntity<>(painelEscolaResponse, HttpStatus.BAD_REQUEST);
    }
    if (censoRepository.countCensoByAnoAndCodINEP(year, codINEP) == 0){
      painelEscolaResponse.addError(responseID,
              HttpStatus.BAD_REQUEST.value(),
              "School '%d' doesn't exist.".formatted(codINEP));
      return new ResponseEntity<>(painelEscolaResponse, HttpStatus.BAD_REQUEST);
    }

    IED ied = this.iedRepository.getIEDForSchool(codINEP, year);
    MeanUtils.MeanCategory meanIED = MeanUtils.meanIED(ied, CategoryMapper::getIEDCategory);

    ICG icg = this.icgRepository.getICGForSchool(codINEP, year);
    MeanUtils.MeanCategory meanICG = MeanUtils.MeanCategory.of(icg.valorMedio(), CategoryMapper::getICGCategory);

    AFD afd = this.afdRepository.getAFDForSchool(codINEP, year);
    MeanUtils.MeanCategory meanAFD = MeanUtils.meanAFD(afd, CategoryMapper::getAFDCategory);

    System.out.println(codINEP);
    Censo censo = this.censoRepository.getCenso(codINEP, year);

    painelEscolaResponse.codINEP(codINEP)
            .ano(year)
            .nameEscola(censo.getNomeEscola())
            .codINEP((int) censo.getCodINEP())
            .address(AddressMapper.getAddress(censo))
            .phoneNumber(censo.getDDD(), censo.getTelefone())
            .nMatriculas(censo.getMatriculadosFundamental().intValue())
            .nDocentes(censo.getDocentesFundamental().intValue())
            .administration(DependenciaMapper.getDependenecia(censo.getDependencia()))
            .id(responseID)
            .ied(meanIED.mean(), meanIED.category())
            .icg(meanICG.mean(), meanICG.category())
            .afd(meanAFD.mean(), meanAFD.category())
            .idebFinais(null)
            .idebFinaisProjection(null)
            .idebIniciais(null)
            .idebIniciaisProjection(null);

    if(AvailableYears.isIdebAvailable(year)){
      IDEB ideb = this.idebRepository.getIDEBForSchool(codINEP, year);
      painelEscolaResponse.idebFinais(ideb.getAnosFinais())
              .idebFinaisProjection(ideb.getProjecaoAF())
              .idebIniciais(ideb.getAnosIniciais())
              .idebIniciaisProjection(ideb.getProjecaoAI());
    }

    return ResponseEntity.ok(painelEscolaResponse);
  }
}
