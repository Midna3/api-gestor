package edu.apigestor.entity.response;

import java.util.Map;

/**
 * <p>Essa classe representa uma resposta para para solicitações do Ideb a nível regional.</p>
 *
 * @author lucas-lins
 * @version 1.0
 * @see IdebResponse
 */
public class IdebRegionalResponse extends IdebResponse {

  private String region;

  /**
   * Adiciona uma região para essa resposta.
   *
   * @param region nome do estado/unidade federativa.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public IdebRegionalResponse region(String region) {
    this.region = region;
    return this;
  }

  @Override
  protected Map<String, Object> additionalAttributes() {
    return Map.of("region", this.region);
  }
}
