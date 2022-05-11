package edu.apigestor.control.services.imp;

import edu.apigestor.control.mappers.CategoryMapper;
import edu.apigestor.control.mappers.CountryMapper;
import edu.apigestor.control.mappers.CountryMapper.CountryID;
import edu.apigestor.control.services.IHomeService;
import edu.apigestor.control.utils.AvailableYears;
import edu.apigestor.data.repository.AFDRepository;
import edu.apigestor.data.repository.ICGRepository;
import edu.apigestor.data.repository.IDEBRepository;
import edu.apigestor.data.repository.IEDRepository;
import edu.apigestor.data.repository.IRDRepository;
import edu.apigestor.data.repository.TDIRepository;
import edu.apigestor.entity.domain.IED;
import edu.apigestor.entity.domain.IRD;
import edu.apigestor.entity.domain.TDI;
import edu.apigestor.entity.response.HomeDadosNacionalResponse;
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
    double meanIED = (1 * ied.getPercentageN1() +
        2 * ied.getPercentageN2() +
        3 * ied.getPercentageN3() +
        4 * ied.getPercentageN4() +
        5 * ied.getPercentageN5() +
        6 * ied.getPercentageN6()) / 100;

    IRD ird = this.irdRepository.getIRDForCountry(code, year);
    double meanIRD = ird.getMediaTotal();

    TDI tdi = this.tdiRepository.getTDIForCountry(code, year);
    double meanTDI = tdi.getPercentageFundamentalTotal();

    response.country(countryName)
        .id(responseID)
        .ied(meanIED, CategoryMapper.getIEDCategory(meanIED))
        .ird(meanIRD, CategoryMapper.getIRDCategory(meanIRD))
        .tdi(meanTDI);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
