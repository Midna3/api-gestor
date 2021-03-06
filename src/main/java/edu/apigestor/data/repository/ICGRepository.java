package edu.apigestor.data.repository;

import edu.apigestor.entity.domain.ICG;
import edu.apigestor.entity.domain.ICG.ICGKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Essa interface possui métodos que operam na coleção de todas as entidades ICG presentes no Banco
 * de Dados. Os diferentes métodos desse repositório são utilizados pelo pacote de serviços da
 * camada de controle.
 *
 * @version 0.1
 */
public interface ICGRepository extends Repository<ICG, ICGKey> {

  @Query("SELECT icg FROM ICG icg WHERE "
      + "icg.codPais = :codPais AND "
      + "icg.ano = :year AND "
      + "icg.tipo = 0 AND "
      + "icg.localizacao = 'Total' AND "
      + "icg.dependencia = 'Total'")
  ICG getICGForCountry(int codPais, int year);

  @Query("SELECT icg FROM ICG icg WHERE "
      + "icg.codRegiao = :codRegiao AND "
      + "icg.ano = :year AND "
      + "icg.tipo = 1 AND "
      + "icg.localizacao = 'Total' AND "
      + "icg.dependencia = 'Total'")
  ICG getICGForRegion(int codRegiao, int year);
  @Query("SELECT icg FROM ICG icg WHERE "
      + "icg.codINEP = :codEscola AND "
      + "icg.ano = :year AND "
      + "icg.tipo = 4")
  ICG getICGForSchool(int codEscola, int year);
}
