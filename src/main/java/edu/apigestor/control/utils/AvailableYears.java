package edu.apigestor.control.utils;

import java.util.Arrays;
import java.util.stream.IntStream;

public final class AvailableYears {

  private static final int[] YEARS = IntStream.range(2017, 2020 + 1).toArray();

  private AvailableYears() {

  }

  public static boolean isAvailable(int year) {
    return Arrays.stream(AvailableYears.YEARS).anyMatch(i -> i == year);
  }
}
