package edu.apigestor.entity.response;

import java.util.Map;

/**
 * <p>Essa classe representa uma resposta para para solicitações do Ideb a nível regional.</p>
 *
 * @author moesiof
 * @version 1.0
 * @see IdebResponse
 */
public class IdebEstadualResponse extends IdebResponse {

  private String state;

  /**
   * Adiciona um estado para essa resposta.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public IdebEstadualResponse state(String state) {
    this.state = state;
    return this;
  }

  @Override
  protected Map<String, Object> additionalAttributes() {
    return Map.of("state", this.state);
  }
}
