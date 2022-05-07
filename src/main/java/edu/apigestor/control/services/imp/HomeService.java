package edu.apigestor.control.services.imp;

import edu.apigestor.control.mappers.CategoryMapper;
import edu.apigestor.control.mappers.CountryMapper;
import edu.apigestor.control.mappers.CountryMapper.CountryID;
import edu.apigestor.control.services.IHomeService;
import edu.apigestor.data.repositories.AFDRepository;
import edu.apigestor.data.repositories.IEDRepository;
import edu.apigestor.data.repositories.IRDRepository;
import edu.apigestor.data.repositories.TDIRepository;
import edu.apigestor.entity.domain.AFD;
import edu.apigestor.entity.domain.IED;
import edu.apigestor.entity.domain.IRD;
import edu.apigestor.entity.domain.TDI;
import edu.apigestor.entity.response.HomeDadosNacionalResponse;
import edu.apigestor.entity.response.HomeDadosRegionalResponse;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class HomeService implements IHomeService {

  private final AtomicLong counter = new AtomicLong();

  @Autowired
  private AFDRepository afdRepository;

  @Autowired
  private TDIRepository tdiRepository;

  @Autowired
  private IEDRepository iedRepository;

  @Autowired
  private IRDRepository irdRepository;

  @Override
  public ResponseEntity<HomeDadosRegionalResponse> dataForRegion(String region, String country) {
    return null;
  }

  @Override
  public ResponseEntity<HomeDadosNacionalResponse> dataForCountry(String country) {
    HomeDadosNacionalResponse response = new HomeDadosNacionalResponse();
    HttpStatus status = HttpStatus.OK;
    long id = this.counter.incrementAndGet();
    CountryID countryID = CountryMapper.getCountry(country);
    int countryCode = countryID.code();

    if (countryCode == -1) {
      status = HttpStatus.BAD_REQUEST;
      response.addError(id, status.value(), "Country '%s' not found".formatted(country));
    } else {
      AFD afd = this.afdRepository.afdCountryLatest(countryCode);
      TDI tdi = this.tdiRepository.tdiCountryLatest(countryCode);
      IED ied = this.iedRepository.iedCountryLatest(countryCode);
      IRD ird = this.irdRepository.irdCountryLatest(countryCode);

      double meanAFD = (1 * afd.percentageG1() +
          2 * afd.percentageG2() +
          3 * afd.percentageG3() +
          4 * afd.percentageG4() +
          5 * afd.percentageG5()) / 100;

      double meanIED = (1 * ied.getPercentageN1() +
          2 * ied.getPercentageN2() +
          3 * ied.getPercentageN3() +
          4 * ied.getPercentageN4() +
          5 * ied.getPercentageN5() +
          6 * ied.getPercentageN6()) / 100;

      double meanIRD = ird.getPercentageMediaTotal();

      response.country(countryID.name())
          .id(id)
          .afd(meanAFD, CategoryMapper.getAFDCategory(meanAFD))
          .tdi(tdi.getPercentageFundamentalTotal())
          .icg(null, null)
          .ied(meanIED, CategoryMapper.getIEDCategory(meanIED))
          .ird(meanIRD, CategoryMapper.getIRDCategory(meanIRD));
    }

    return new ResponseEntity<>(response, status);
  }
}
