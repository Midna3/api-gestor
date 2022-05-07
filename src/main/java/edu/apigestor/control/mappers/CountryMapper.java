package edu.apigestor.control.mappers;

import java.util.Locale;

public final class CountryMapper {

  private CountryMapper() {

  }

  public static CountryID getCountry(String country) {
    String lower = country.toLowerCase(Locale.ROOT);

    if (lower.contains("brasil") || lower.contains("brazil")) {
      return new CountryID("Brasil", 999);
    }

    return new CountryID("null", -1);
  }

  public record CountryID(String name, int code) {

  }
}
