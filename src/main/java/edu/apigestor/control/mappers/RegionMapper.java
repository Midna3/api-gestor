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
   * @return {@link regionID} com o nome padrão da região e seu código no BD.
   */
  public static RegionID getRegion(String region) {
    String lower = region.toLowerCase(Locale.ROOT);

    switch(lower){
      case "norte": case "n":
        return new RegionID("n", 1);
      case "nordeste": case "ne":
        return new RegionID("ne", 2);
      case "sudeste": case "se":
        return new RegionID("se", 3);
      case "sul": case "s":
        return new RegionID("s", 4);
      case "co":
        return new RegionID("co", 5);
      default:
        return new RegionID(null, -1);
    }
  }

  /**
   * Classe utilitária que armazena uma codificação de uma região (nome e código).
   *
   * @version 1.0
   */
  public record RegionID(String name, int code) {

  }

}
