package edu.apigestor.data.repository;

import edu.apigestor.entity.domain.AFD;
import edu.apigestor.entity.domain.AFD.AFDKey;
import org.springframework.data.repository.Repository;

/**
 * Essa interface possui métodos que operam na coleção de todas as entidades IDEB presentes no Banco
 * de Dados. Os diferentes métodos desse repositório são utilizados pelo pacote de serviços da
 * camada de controle.
 *
 * @version 0.1
 */
public interface IDEBRepository extends Repository<AFD, AFDKey> {
  // Temporariamente estamos usando as chaves do AFD já que ainda não possuímos essa entidade
  //  implementada completamente (dessa forma, conseguimos executar o código).
  //  Alterar quando tivermos essa entidade.

}
