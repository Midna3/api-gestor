package edu.apigestor.data.repositories;

import edu.apigestor.entity.domain.TDI;
import edu.apigestor.entity.domain.TDI.TDIKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface TDIRepository extends Repository<TDI, TDIKey> {

  @Query(value = "SELECT t from TDI t WHERE "
      + "t.codPais = :codCountry AND "
      + "t.ano = 2019 AND "
      + "t.tipo = 0 AND "
      + "t.dependencia = 'Total' AND "
      + "t.localizacao = 'Total'")
  TDI tdiCountryLatest(@Param("codCountry") int codCountry);

}
