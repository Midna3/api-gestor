package edu.apigestor.control.services.imp;

import edu.apigestor.control.mappers.CategoryMapper;
import edu.apigestor.control.mappers.CountryMapper;
import edu.apigestor.control.mappers.CountryMapper.CountryID;
import edu.apigestor.control.services.IHomeService;
import edu.apigestor.control.utils.AvailableYears;
import edu.apigestor.control.utils.MeanUtils;
import edu.apigestor.control.utils.MeanUtils.MeanCategory;
import edu.apigestor.control.utils.SortUtils;
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
import edu.apigestor.entity.response.HomeEscolaResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class Home implements IHomeService {

  private final AtomicLong count = new AtomicLong();

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
    long responseID = this.count.getAndIncrement();
    HomeDadosNacionalResponse response = new HomeDadosNacionalResponse();

    if (!AvailableYears.isAvailable(year)) {
      response.addError(responseID,
          HttpStatus.BAD_REQUEST.value(),
          "Year '%d' is unavailable.".formatted(year));
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    CountryID countryID = CountryMapper.getCountry(country);
    int code = countryID.code();
    String countryName = countryID.name();

    if (code == -1) {
      response.addError(responseID,
          HttpStatus.BAD_REQUEST.value(),
          "Country '%s' doesn't exist.".formatted(country));
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    IED ied = this.iedRepository.getIEDForCountry(code, year);
    MeanCategory meanIED = MeanUtils.meanIED(ied, CategoryMapper::getIEDCategory);

    IRD ird = this.irdRepository.getIRDForCountry(code, year);
    MeanCategory meanIRD = MeanCategory.of(ird.getMediaTotal(), CategoryMapper::getIRDCategory);

    TDI tdi = this.tdiRepository.getTDIForCountry(code, year);
    Double meanTDI = tdi.getPercentageFundamentalTotal();

    ICG icg = this.icgRepository.getICGForCountry(code, year);
    MeanCategory meanICG = MeanCategory.of(icg.valorMedio(), CategoryMapper::getICGCategory);

    AFD afd = this.afdRepository.getAFDForCountry(code, year);
    MeanCategory meanAFD = MeanUtils.meanAFD(afd, CategoryMapper::getAFDCategory);

    response.country(countryName)
        .ano(year)
        .id(responseID)
        .ied(meanIED.mean(), meanIED.category())
        .ird(meanIRD.mean(), meanIRD.category())
        .tdi(meanTDI)
        .icg(meanICG.mean(), meanICG.category())
        .afd(meanAFD.mean(), meanAFD.category())
        .idebFinais(null)
        .idebFinaisProjection(null)
        .idebIniciais(null)
        .idebIniciaisProjection(null);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<HomeEscolaResponse> listSchool(String name, int limit) {
    HomeEscolaResponse response = new HomeEscolaResponse();

    // JPQL: SELECT s FROM Censo s WHERE lower(s.nomeEscola) LIKE '%:name%' OR
    //                                   lower(s.nomeEscola) LIKE '%substring(:name, i, k)%' OR
    //                                   lower(s.nomeEscola) LIKE '%substring(:name, j, l)%' OR
    //                                   lower(s.nomeEscola) ...
    // Outra opção é usar Full-Text Search com o MySQL, todavia é necessário utilizar
    //  indices FULLTEXT. Talvez essa solução fica para uma próxima versão.

    // O retorno é uma lista de Censo: List<Censo> result
    // Podemos dar um sort usando streams:

    List<Object> result = SortUtils.sortSchoolList(new ArrayList<>(), name);
    int size = result.size();
    int lastIndex = Math.min(limit, size);
    result = result.subList(0, lastIndex);

    response.addEntry("Default",
        0,
        "State, City",
        this.count.getAndIncrement());

    return ResponseEntity.ok(response);
  }
}
