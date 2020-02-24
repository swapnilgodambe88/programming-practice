package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link CountAndSay}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class CountAndSayTest {

  private final CountAndSay obj = new CountAndSay();

  @Test
  public void testSequence1() {
    Assert.assertEquals("1", obj.countAndSay(1));
  }

  @Test
  public void testSequence2() {
    Assert.assertEquals("11", obj.countAndSay(2));
  }

  @Test
  public void testSequence3() {
    Assert.assertEquals("21", obj.countAndSay(3));
  }

  @Test
  public void testSequence4() {
    Assert.assertEquals("1211", obj.countAndSay(4));
  }

  @Test
  public void testSequence5() {
    Assert.assertEquals("111221", obj.countAndSay(5));
  }
}
