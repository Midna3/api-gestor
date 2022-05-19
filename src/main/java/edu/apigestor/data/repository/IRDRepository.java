package edu.apigestor.data.repository;

import edu.apigestor.entity.domain.IED;
import edu.apigestor.entity.domain.IRD;
import edu.apigestor.entity.domain.IRD.IRDKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Essa interface possui métodos que operam na coleção de todas as entidades IRD presentes no Banco
 * de Dados. Os diferentes métodos desse repositório são utilizados pelo pacote de serviços da
 * camada de controle.
 *
 * @version 0.1
 */
public interface IRDRepository extends Repository<IRD, IRDKey> {

  @Query("SELECT ird FROM IRD ird WHERE "
      + "ird.codPais = :codPais AND "
      + "ird.ano = :year AND "
      + "ird.tipo = 0 AND "
      + "ird.localizacao = 'Total' AND "
      + "ird.dependencia = 'Total'")
  IRD getIRDForCountry(int codPais, int year);

  @Query("SELECT ird FROM IRD ird WHERE "
  + "ird.codRegiao = :codRegiao AND "
  + "ird.ano = :year AND "
  + "ird.tipo = 1")
IRD getIRDForRegion(int codRegiao, int year);


}
