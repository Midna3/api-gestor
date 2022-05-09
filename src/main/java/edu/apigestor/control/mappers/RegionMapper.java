package edu.apigestor.control.mappers;

/**
 * Essa é uma classe utilitária que permite mapear Strings de regiões para códigos utilizados no
 * Banco de dados.
 *
 * @version 1.0
 */
public final class RegionMapper {

  private RegionMapper() {

  }

  /**
   * Classe utilitária que armazena uma codificação de uma região (nome e código).
   *
   * @version 1.0
   */
  public record RegionID(String name, int code) {

  }

}
