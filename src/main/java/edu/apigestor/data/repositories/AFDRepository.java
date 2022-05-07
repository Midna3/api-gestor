package edu.apigestor.data.repositories;

import edu.apigestor.entity.domain.AFD;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface AFDRepository extends Repository<AFD, AFD.AFDKey> {

  @Query(value = "SELECT a from AFD a WHERE a.codINEP = :codINEP")
  Iterable<AFD> afdFromCodINEP(@Param("codINEP") int codINEP);

  @Query(value = "SELECT a from AFD a WHERE "
      + "a.codPais = :codCountry AND "
      + "a.ano = 2019 AND "
      + "a.tipo = 0 AND "
      + "a.dependencia = 'Total' AND "
      + "a.localizacao = 'Total'")
  AFD afdCountryLatest(@Param("codCountry") int codCountry);
}
