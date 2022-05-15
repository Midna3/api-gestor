package edu.apigestor.control.services.imp;

import edu.apigestor.control.mappers.CategoryMapper;
import edu.apigestor.control.mappers.CountryMapper;
import edu.apigestor.control.mappers.CountryMapper.CountryID;
import edu.apigestor.control.mappers.RegionMapper;
import edu.apigestor.control.mappers.RegionMapper.RegionID;
import edu.apigestor.control.services.IHomeService;
import edu.apigestor.control.utils.AvailableYears;
import edu.apigestor.control.utils.MeanUtils;
import edu.apigestor.control.utils.MeanUtils.MeanCategory;
import edu.apigestor.data.repository.AFDRepository;
import edu.apigestor.data.repository.CensoRepository;
import edu.apigestor.data.repository.ICGRepository;
import edu.apigestor.data.repository.IDEBRepository;
import edu.apigestor.data.repository.IEDRepository;
import edu.apigestor.data.repository.IRDRepository;
import edu.apigestor.data.repository.TDIRepository;
import edu.apigestor.entity.domain.AFD;
import edu.apigestor.entity.domain.Censo;
import edu.apigestor.entity.domain.ICG;
import edu.apigestor.entity.domain.IDEB;
import edu.apigestor.entity.domain.IED;
import edu.apigestor.entity.domain.IRD;
import edu.apigestor.entity.domain.TDI;
import edu.apigestor.entity.response.HomeDadosNacionalResponse;
import edu.apigestor.entity.response.HomeDadosRegionalResponse;
import edu.apigestor.entity.response.HomeEscolaResponse;
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

  @Autowired
  private CensoRepository censoRepository;

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

    if(AvailableYears.isIdebAvailable(year)){
      IDEB ideb = this.idebRepository.getIDEBForCountry(code, year);
      response.idebFinais(ideb.getAnosFinais())
          .idebFinaisProjection(ideb.getProjecaoAF())
          .idebIniciais(ideb.getAnosIniciais())
          .idebIniciaisProjection(ideb.getProjecaoAI());
    }
    return ResponseEntity.ok(response);
  }

  @Override
  public ResponseEntity<HomeDadosRegionalResponse> dataRegion(String region, int year) {
    long responseID = this.count.getAndIncrement();
    HomeDadosRegionalResponse response = new HomeDadosRegionalResponse();

    if (!AvailableYears.isAvailable(year)) {
      response.addError(responseID,
          HttpStatus.BAD_REQUEST.value(),
          "Year '%d' is unavailable.".formatted(year));
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    RegionID regionID = RegionMapper.getRegion(region);
    int code = regionID.code();
    String regionName = regionID.name();

    if (code == -1) {
      response.addError(responseID,
          HttpStatus.BAD_REQUEST.value(),
          "Region '%s' doesn't exist.".formatted(region));
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    IED ied = this.iedRepository.getIEDForRegion(code, year);
    MeanCategory meanIED = MeanUtils.meanIED(ied, CategoryMapper::getIEDCategory);

    IRD ird = this.irdRepository.getIRDForRegion(code, year);
    MeanCategory meanIRD = MeanCategory.of(ird.getMediaTotal(), CategoryMapper::getIRDCategory);

    TDI tdi = this.tdiRepository.getTDIForRegion(code, year);
    Double meanTDI = tdi.getPercentageFundamentalTotal();

    ICG icg = this.icgRepository.getICGForRegion(code, year);
    MeanCategory meanICG = MeanCategory.of(icg.valorMedio(), CategoryMapper::getICGCategory);
    
    AFD afd = this.afdRepository.getAFDForRegion(code, year);
    MeanCategory meanAFD = MeanUtils.meanAFD(afd, CategoryMapper::getAFDCategory);

    response.region(regionName)
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
    
    if(AvailableYears.isIdebAvailable(year)){
      IDEB ideb = this.idebRepository.getIDEBForRegion(code, year);
      response.idebFinais(ideb.getAnosFinais())
          .idebFinaisProjection(ideb.getProjecaoAF())
          .idebIniciais(ideb.getAnosIniciais())
          .idebIniciaisProjection(ideb.getProjecaoAI());
    }

    return ResponseEntity.ok(response);
  }

  @Override
  public ResponseEntity<HomeEscolaResponse> listSchool(String name, int limit) {
    HomeEscolaResponse response = new HomeEscolaResponse();

    List<Censo> schools = this.censoRepository.getSchoolsSimilar(name, limit);

    schools.forEach(s -> response.addEntry(
            s.getNomeEscola(),
            s.getCodINEP(),
            "%s/%s".formatted(s.getNomeEstado(), s.getNomeMunicipio()),
            this.count.getAndIncrement()));

    return ResponseEntity.ok(response);
  }
}
