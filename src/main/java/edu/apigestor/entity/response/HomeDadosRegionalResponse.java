package edu.apigestor.entity.response;

import java.util.Map;

/**
 * <p>Essa classe representa uma resposta para solicitações de dados gerais sobre a educação
 * brasileira a nível regional.</p>
 *
 * @author moesiof
 * @version 1.0
 * @see HomeDadosResponse
 */
public class HomeDadosRegionalResponse extends HomeDadosResponse {

  private String region;

  /**
   * Adiciona a região dessa resposta.
   *
   * @param region nome da região.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosRegionalResponse region(String region) {
    this.region = region;
    return this;
  }

  @Override
  protected Map<String, Object> additionalAttributes() {
    return Map.of("region", this.region);
  }
}
