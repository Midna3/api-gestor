package edu.apigestor.data.repositories;

import edu.apigestor.entity.domain.IRD;
import edu.apigestor.entity.domain.IRD.IRDKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface IRDRepository extends Repository<IRD, IRDKey> {

  @Query(value = "SELECT ird from IRD ird WHERE "
      + "ird.codPais = :codCountry AND "
      + "ird.ano = 2019 AND "
      + "ird.tipo = 0 AND "
      + "ird.dependencia = 'Total' AND "
      + "ird.localizacao = 'Total'")
  IRD irdCountryLatest(@Param("codCountry") int codCountry);

}
