package edu.apigestor.control.utils;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * Essa classe disponibiliza métodos utilitários para o cálculo de médias onde algum dos valores
 * pode ser nulo.
 *
 * @version 1.0
 */
public final class MeanUtils {

  private MeanUtils() {

  }

  /**
   * Esse método retorna a média para um dado conjunto de entrada formado por pesos e valores. Caso
   * não sejam passadas entradas ou algum dos valores/pesos forem nulos, esse método retorna null.
   *
   * @param values pares de peso e valor.
   * @return a média desses valores (média = sum(peso*valor)/sum(peso)) ou null.
   */
  public static Double meanOf(MeanEntry... values) {
    if (values.length == 0 || Arrays.stream(values)
        .anyMatch(e -> e.value == null || e.weight == null)) {
      return null;
    }

    double wSum = Arrays.stream(values).mapToDouble(v -> v.weight).sum();

    return (Arrays.stream(values)
        .mapToDouble(e -> e.weight * e.value)
        .sum()) / wSum;
  }

  /**
   * Esse método retorna a média dado um intervalo de valores e os pesos associados com cada valor
   * nesse intervalo.
   *
   * @param v0      primeiro valor (inteiro, inclusivo).
   * @param vn      último valor (inteiro, exclusivo).
   * @param weights pesos associados para cada um dos valores no intervalo inteiro [v0..vn)
   * @return a média desses valores (média = sum(peso*valor)/sum(peso))
   */
  public static Double meanOf(int v0, int vn, Double... weights) {
    double[] values = IntStream.range(v0, vn).mapToDouble(Double::valueOf).toArray();

    if (weights.length != values.length) {
      return null;
    }

    MeanEntry[] entries = IntStream.range(0, weights.length)
        .mapToObj(i -> new MeanEntry(weights[i], values[i]))
        .toArray(MeanEntry[]::new);

    return MeanUtils.meanOf(entries);
  }

  /**
   * Esse método retorna um par média-categoria dado um intervalo de valores, os pesos associados
   * com cada valor nesse intervalo, e uma função de mapeamento.
   *
   * @param v0             primeiro valor (inteiro, inclusivo).
   * @param vn             último valor (inteiro, exclusivo).
   * @param categoryMapper função de mapeamento de uma média para sua categoria.
   * @param weights        pesos associados para cada um dos valores no intervalo inteiro [v0..vn)
   * @return a média desses valores (pode ser null) e sua respectiva categoria (pode ser null).
   */
  public static MeanCategory meanOf(int v0, int vn,
      Function<Double, String> categoryMapper,
      Double... weights) {
    return MeanCategory.of(MeanUtils.meanOf(v0, vn, weights), categoryMapper);
  }

  /**
   * Esse método retorna um par média-categoria para um dado conjunto de entrada formado por pesos,
   * valores e uma função de mapeamento.
   *
   * @param categoryMapper função de mapeamento de uma média para uma categoria.
   * @param values         pares de peso e valor ({@link MeanEntry}).
   * @return a média desses valores (média = sum(peso*valor)/sum(peso)) ou null.
   */
  public static MeanCategory meanOf(Function<Double, String> categoryMapper, MeanEntry... values) {
    return MeanCategory.of(MeanUtils.meanOf(values), categoryMapper);
  }

  /**
   * Essa classe representa um par peso-valor.
   *
   * @version 1.0
   */
  public record MeanEntry(Double weight, Double value) {

    public static MeanEntry of(Double w, Double v) {
      return new MeanEntry(w, v);
    }
  }

  /**
   * Essa classe representa um par média-categoria.
   *
   * @version 1.0
   */
  public record MeanCategory(Double mean, String category) {

    public static MeanCategory of(Double mean, Function<Double, String> categoryMapper) {
      return new MeanCategory(mean, (mean != null) ? categoryMapper.apply(mean) : null);
    }
  }
}
