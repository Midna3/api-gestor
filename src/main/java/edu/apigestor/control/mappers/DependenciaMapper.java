package edu.apigestor.control.mappers;

public final class DependenciaMapper {

  private DependenciaMapper() {

  }

  public static String getDependenecia(String value) {
    return switch (value) {
      case "1" -> "Federal";
      case "2" -> "Estadual";
      case "3" -> "Municipal";
      case "4" -> "Privado";
      default -> "null";
    };
  }

}
