package edu.apigestor.entity.response;

import java.util.Map;

/**
 * <p>Essa classe representa uma resposta para solicitações de dados gerais sobre a educação
 * brasileira a nível nacional.</p>
 *
 * @author lucas-lins
 * @version 1.0
 * @see HomeDadosResponse
 */
public class HomeDadosEstadualResponse extends HomeDadosResponse {

  private String state;

  /**
   * Adiciona o país dessa resposta.
   *
   * @param state nome do país.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosEstadualResponse state(String state) {
    this.state = state;
    return this;
  }

  @Override
  protected Map<String, Object> additionalAttributes() {
    return Map.of("state", this.state);
  }
}
