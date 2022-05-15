package edu.apigestor.control.utils;

import java.util.Arrays;
import java.util.stream.IntStream;

public final class AvailableYears {

  private static final int[] YEARS = IntStream.range(2017, 2020 + 1).toArray();

  private static final int[] YEARS_IDEB = new int[]{2017, 2019};

  private AvailableYears() {

  }

  public static boolean isAvailable(int year) {
    return Arrays.stream(AvailableYears.YEARS).anyMatch(i -> i == year);
  }

  public static boolean isIdebAvailable(int year) {
    return Arrays.stream(AvailableYears.YEARS_IDEB).anyMatch(i -> i == year);
  }
}
