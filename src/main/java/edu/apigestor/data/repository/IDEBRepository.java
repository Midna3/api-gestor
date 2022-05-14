package edu.apigestor.data.repository;

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
            + "ideb.dependencia = 'Total' AND "
            + "ideb.tipo = 0")
    IDEB getIDEBForCountry(int codPais, int year);

}
