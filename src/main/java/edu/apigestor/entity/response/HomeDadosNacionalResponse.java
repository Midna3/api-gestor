package edu.apigestor.entity.response;

import java.util.Map;

/**
 * <p>Essa classe representa uma resposta para solicitações de dados gerais sobre a educação
 * brasileira a nível nacional.</p>
 *
 * @author moesiof
 * @version 1.0
 * @see HomeDadosResponse
 */
public class HomeDadosNacionalResponse extends HomeDadosResponse {

  private String country = "Brasil"; // País padrão da resposta.

  /**
   * Adiciona o país dessa resposta.
   *
   * @param country nome do país.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosNacionalResponse country(String country) {
    this.country = country;
    return this;
  }

  @Override
  protected Map<String, Object> additionalAttributes() {
    return Map.of("country", this.country);
  }
}
