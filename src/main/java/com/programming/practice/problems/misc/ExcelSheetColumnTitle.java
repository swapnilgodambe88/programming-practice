package com.programming.practice.problems.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel
 * sheet.
 *
 * <p>For example:
 *
 * <p>A -> 1 B -> 2 C -> 3 AA -> 4 AB -> 5 AC -> 6 BA -> 7 BB -> 8 BC -> 9 CA -> 10 CB -> 11 CC ->
 * 12 AAA -> 13 ... Z -> 26 AA -> 27 AB -> 28 ...
 *
 * <pre>
 * Example 1:
 *
 * Input: columnNumber = 1
 * Output: "A"
 *
 * Example 2:
 *
 * Input: columnNumber = 28
 * Output: "AB"
 *
 * Example 3:
 *
 * Input: columnNumber = 701
 * Output: "ZY"
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/excel-sheet-column-title/description/">Excel Sheet
 *     Column Title</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2024.
 */
public final class ExcelSheetColumnTitle {

  private final Map<Integer, Character> columnToCharacterMap = new HashMap<>();

  /** Constructor to initialize the columnToCharacterMap map. */
  public ExcelSheetColumnTitle() {
    final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    for (int i = 1; i <= 26; ++i) {
      columnToCharacterMap.put(i, alphabet.charAt(i - 1));
    }

    // Z will have two entries on Map. One for 26 (edge-case), and other for 0
    columnToCharacterMap.put(0, 'Z');
  }

  /**
   * @param columnNumber The column number on excel sheet.
   * @return The corresponding Excel column title representing the column number.
   */
  public String convertToTitle(final int columnNumber) {
    int num = columnNumber;
    StringBuilder excelColumn = new StringBuilder();

    while (num > 26) {

      final int remainder = num % 26;
      num = Math.floorDiv(num, 26);
      excelColumn.append(columnToCharacterMap.get(remainder));

      if (remainder == 0) {
        num--;
      }
    }

    if (num <= 26) {
      excelColumn.append(columnToCharacterMap.get(num));
    }

    return excelColumn.reverse().toString();
  }
}
