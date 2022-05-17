package edu.apigestor.control.mappers;

import java.util.Locale;

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
   * Dado uma String com o nome de uma região do país, retorna a representação padrão para essa região (código e
   * nome padrão). Caso não exista, retorna um objeto com nome null e código -1.
   *
   * @param region nome da região.
   * @return {@link RegionID} com o nome padrão da região e seu código no BD.
   */
  public static RegionID getRegion(String region) {
    String lower = region.toLowerCase(Locale.ROOT);

    return switch (lower) {
      case "norte", "n" -> new RegionID("Norte", 1);
      case "nordeste", "ne" -> new RegionID("Nordeste", 2);
      case "sudeste", "se" -> new RegionID("Sudeste", 3);
      case "sul", "s" -> new RegionID("Sul", 4);
      case "centro-oeste", "co" -> new RegionID("Centro-Oeste", 5);
      default -> new RegionID(null, -1);
    };
  }

  /**
   * Classe utilitária que armazena uma codificação de uma região (nome e código).
   *
   * @version 1.0
   */
  public record RegionID(String name, int code) {

  }

}
