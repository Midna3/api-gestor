package edu.apigestor.data.repository;

import edu.apigestor.entity.domain.ICG;
import edu.apigestor.entity.domain.IDEB;
import edu.apigestor.entity.domain.IDEB.IDEBKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Essa interface possui métodos que operam na coleção de todas as entidades IDEB presentes no Banco
 * de Dados. Os diferentes métodos desse repositório são utilizados pelo pacote de serviços da
 * camada de controle.
 *
 * @version 0.1
 */
public interface IDEBRepository extends Repository<IDEB, IDEBKey> {

  @Query("SELECT ideb FROM IDEB ideb WHERE "
      + "ideb.codPais = :codPais AND "
      + "ideb.ano = :year AND "
      + "ideb.tipo = 0 AND "
      + "ideb.dependencia = 'Total' ")
  IDEB getIDEBForCountry(int codPais, int year);

  @Query("SELECT ideb FROM IDEB ideb WHERE "
      + "ideb.codRegiao = :codRegiao AND "
      + "ideb.ano = :year AND "
      + "ideb.tipo = 1 AND "
      + "ideb.dependencia = 'Total'")
  IDEB getIDEBForRegion(int codRegiao, int year);

  @Query("SELECT ideb FROM IDEB ideb WHERE "
          + "ideb.codINEP = :codEscola AND "
          + "ideb.ano = :year AND "
          + "ideb.tipo = 4 AND "
          + "ideb.dependencia = 'Total'")
  IDEB getIDEBForSchool(int codEscola, int year);
}
