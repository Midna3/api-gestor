package edu.apigestor.entity.response;

import java.util.Map;

/**
 * <p>Essa classe representa uma resposta para para solicitações do Ideb a nível nacional.</p>
 *
 * @author lucas-lins
 * @version 1.0
 * @see IdebResponse
 */
public class IdebNacionalResponse extends IdebResponse {

  private String country;

  /**
   * Adiciona uma região para essa resposta.
   *
   * @param country nome do país.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public IdebNacionalResponse region(String country) {
    this.country = country;
    return this;
  }

  @Override
  protected Map<String, Object> additionalAttributes() {
    return Map.of("country", this.country);
  }
}
