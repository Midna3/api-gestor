package edu.apigestor.data.repository;

import edu.apigestor.entity.domain.IRD;
import edu.apigestor.entity.domain.IRD.IRDKey;
import org.springframework.data.repository.Repository;

/**
 * Essa interface possui métodos que operam na coleção de todas as entidades IRD presentes no Banco
 * de Dados. Os diferentes métodos desse repositório são utilizados pelo pacote de serviços da
 * camada de controle.
 *
 * @version 0.1
 */
public interface IRDRepository extends Repository<IRD, IRDKey> {

}
