package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link IntegerToEnglishWords}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class IntegerToEnglishWordsTest {

  private final IntegerToEnglishWords obj = new IntegerToEnglishWords();

  @Test
  public void testScenario1() {
    Assert.assertEquals(
        "One Hundred Twenty Three Thousand One Hundred Twenty Three", obj.numberToWords(123123));
  }

  @Test
  public void test30() {
    Assert.assertEquals("Thirty", obj.numberToWords(30));
  }

  @Test
  public void test16() {
    Assert.assertEquals("Sixteen", obj.numberToWords(16));
  }

  @Test
  public void test100() {
    Assert.assertEquals("One Hundred", obj.numberToWords(100));
  }

  @Test
  public void test1000() {
    Assert.assertEquals("One Thousand", obj.numberToWords(1000));
  }

  @Test
  public void test50868() {
    Assert.assertEquals("Fifty Thousand Eight Hundred Sixty Eight", obj.numberToWords(50868));
  }

  @Test
  public void test0() {
    Assert.assertEquals("Zero", obj.numberToWords(0));
  }

  @Test
  public void testBillion() {
    Assert.assertEquals(
        "One Billion One Hundred Twenty Three Million One Hundred Twenty Three Thousand One Hundred Twenty Three",
        obj.numberToWords(1123123123));
  }

  @Test
  public void testMillion() {
    Assert.assertEquals(
        "One Hundred Twenty Three Million One Hundred Twenty Three Thousand One Hundred Twenty Three",
        obj.numberToWords(123123123));
  }
}
