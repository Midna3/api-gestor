package edu.apigestor.control.mappers;

import java.util.Locale;

/**
 * Essa é uma classe utilitária que permite mapear Strings de países para códigos utilizados no
 * Banco de dados.
 *
 * @version 1.0
 */
public final class CountryMapper {

  private CountryMapper() {

  }

  /**
   * Dado uma String com o nome de um país, retorna a representação padrão para esse país (código e
   * nome padrão). Caso não exista, retorna um objeto com nome null e código -1.
   *
   * @param country nome do país.
   * @return {@link CountryID} com o nome padrão do país e seu código no BD.
   */
  public static CountryID getCountry(String country) {
    String lower = country.toLowerCase(Locale.ROOT);

    if (lower.contains("brasil") || lower.contains("brazil")) {
      return new CountryID("Brasil", 999);
    }

    return new CountryID(null, -1);
  }

  /**
   * Classe utilitária que armazena uma codificação de um país (nome e código).
   *
   * @version 1.0
   */
  public record CountryID(String name, int code) {

  }
}