package edu.apigestor.control.utils;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.text.similarity.LevenshteinDistance;

/**
 * Essa classe disponibiliza métodos utilitários para ordenação.
 *
 * @version 1.0
 */
public final class SortUtils {

  private static final LevenshteinDistance levenshtein = LevenshteinDistance.getDefaultInstance();


  private SortUtils() {

  }

  /**
   * Ordena uma lista de escolas conforme a distância do nome dessas escolas para um nome
   * referência.
   *
   * @param schools lista de objetos que representam as escolas.
   * @param target  nome de referência para calcular a distância entre as escolas.
   * @return uma nova lista ordenada conforme a distância.
   */
  public static List<Object> sortSchoolList(List<Object> schools, String target) {
    return schools.stream()
        .map(s -> new SchoolDistance(s,
            SortUtils.levenshtein.apply("", target)))
        .sorted()
        .map(sd -> sd.school)
        .collect(Collectors.toList());
  }

  private record SchoolDistance(Object school, Integer distance) implements
      Comparable<SchoolDistance> {

    @Override
    public int compareTo(SchoolDistance o) {
      if (this.distance.equals(o.distance)) {
        return 0;
      } else if (this.distance > o.distance) {
        return -1;
      }
      return 1;
    }
  }

}
