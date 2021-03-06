package edu.apigestor.data.repository;

import edu.apigestor.entity.domain.TDI;
import edu.apigestor.entity.domain.TDI.TDIKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Essa interface possui métodos que operam na coleção de todas as entidades TDI presentes no Banco
 * de Dados. Os diferentes métodos desse repositório são utilizados pelo pacote de serviços da
 * camada de controle.
 *
 * @version 0.1
 */
public interface TDIRepository extends Repository<TDI, TDIKey> {

  @Query("SELECT tdi FROM TDI tdi WHERE "
      + "tdi.codPais = :codPais AND "
      + "tdi.ano = :year AND "
      + "tdi.tipo = 0 AND "
      + "tdi.localizacao = 'Total' AND "
      + "tdi.dependencia = 'Total'")
  TDI getTDIForCountry(int codPais, int year);

  @Query("SELECT tdi FROM TDI tdi WHERE "
  + "tdi.codRegiao = :codRegiao AND "
  + "tdi.ano = :year AND "
  + "tdi.tipo = 1 AND "
  + "tdi.localizacao = 'Total' AND "
  + "tdi.dependencia = 'Total'")
  TDI getTDIForRegion(int codRegiao, int year);

  @Query("SELECT tdi FROM TDI tdi WHERE "
  + "tdi.codINEP = :codEscola AND "
  + "tdi.ano = :year AND "
  + "tdi.tipo = 4")
  TDI getTDIForSchool(int codEscola, int year);
}
