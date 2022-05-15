package edu.apigestor.control.mappers;

/**
 * Essa é uma classe utilitária que permite mapear Strings de estados (UFs) para códigos utilizados
 * no Banco de dados.
 *
 * @version 1.0
 */
public final class StateMapper {

  private StateMapper() {

  }

  /**
   * Classe utilitária que armazena uma codificação de um estado (nome e código).
   *
   * @version 1.0
   */
  public record StateID(String name, int code) {

  }
}
