package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BasicCalculator2}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BasicCalculator2Test {

  private final BasicCalculator2 obj = new BasicCalculator2();

  @Test
  public void testScenario1() {
    Assert.assertEquals(7, obj.calculate_approach1("3+2*2"));
    Assert.assertEquals(7, BasicCalculator2.calculate_approach2("3+2*2"));
  }

  @Test
  public void testScenario2() {
    Assert.assertEquals(1, obj.calculate_approach1(" 3/2 "));
    Assert.assertEquals(1, BasicCalculator2.calculate_approach2(" 3/2 "));
  }

  @Test
  public void testScenario3() {
    Assert.assertEquals(5, obj.calculate_approach1(" 3+5 / 2 "));
    Assert.assertEquals(5, BasicCalculator2.calculate_approach2(" 3+5 / 2 "));
  }

  @Test
  public void testScenario4() {
    Assert.assertEquals(13, obj.calculate_approach1("14-3/2"));
    Assert.assertEquals(13, BasicCalculator2.calculate_approach2("14-3/2"));
  }

  public static int calculate_approach3(final String s) {
    final int length = s.length();
    if (s == null || length == 0) return 0;
    int currentNumber = 0, lastNumber = 0, result = 0;
    char operation = '+';
    for (int i = 0; i < length; i++) {
      final char currentChar = s.charAt(i);
      if (Character.isDigit(currentChar)) {
        currentNumber = (currentNumber * 10) + (currentChar - '0');
      }
      if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar)
          || i == length - 1) {
        if (operation == '+' || operation == '-') {
          result += lastNumber;
          lastNumber = (operation == '+') ? currentNumber : -currentNumber;
        } else if (operation == '*') {
          lastNumber = lastNumber * currentNumber;
        } else if (operation == '/') {
          lastNumber = lastNumber / currentNumber;
        }
        operation = currentChar;
        currentNumber = 0;
      }
    }
    result += lastNumber;
    return result;
  }
}
