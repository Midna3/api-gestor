package edu.apigestor.data.repositories;

import edu.apigestor.entity.domain.IED;
import edu.apigestor.entity.domain.IED.IEDKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface IEDRepository extends Repository<IED, IEDKey> {

  @Query(value = "SELECT ied from IED ied WHERE "
      + "ied.codPais = :codCountry AND "
      + "ied.ano = 2019 AND "
      + "ied.tipo = 0 AND "
      + "ied.dependencia = 'Total' AND "
      + "ied.localizacao = 'Total'")
  IED iedCountryLatest(@Param("codCountry") int codCountry);

}
