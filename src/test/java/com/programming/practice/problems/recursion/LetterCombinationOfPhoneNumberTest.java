package com.programming.practice.problems.recursion;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link
 * com.programming.practice.problems.recursion.LetterCombinationOfPhoneNumber}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class LetterCombinationOfPhoneNumberTest {

  private final LetterCombinationOfPhoneNumber obj = new LetterCombinationOfPhoneNumber();

  @Test
  public void testEmpty() {
    Assert.assertTrue(obj.letterCombinations("").isEmpty());
  }

  @Test
  public void testDigit1() {
    Assert.assertTrue(obj.letterCombinations("1").isEmpty());
  }

  @Test
  public void testSingleDigit() {
    final List<String> expectedCombinationList = Arrays.asList("a", "b", "c");
    Assert.assertEquals(expectedCombinationList, obj.letterCombinations("2"));
  }

  @Test
  public void testTwoDigit() {
    final List<String> expectedCombinationList =
        Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");

    Assert.assertEquals(expectedCombinationList, obj.letterCombinations("23"));
  }
}
