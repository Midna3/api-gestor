package edu.apigestor.data.repository;

import edu.apigestor.entity.domain.IED;
import edu.apigestor.entity.domain.IED.IEDKey;
import org.springframework.data.repository.Repository;

/**
 * Essa interface possui métodos que operam na coleção de todas as entidades IED presentes no Banco
 * de Dados. Os diferentes métodos desse repositório são utilizados pelo pacote de serviços da
 * camada de controle.
 *
 * @version 0.1
 */
public interface IEDRepository extends Repository<IED, IEDKey> {

}
