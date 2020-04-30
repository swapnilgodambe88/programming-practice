package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ShortestWayToFormString}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ShortestWayToFormStringTest {

  private final ShortestWayToFormString obj = new ShortestWayToFormString();

  @Test
  public void testScenario1() {
    final String source = "abc";
    final String target = "abcbc";

    Assert.assertEquals(2, obj.shortestWay(source, target));
  }

  @Test
  public void testScenario2() {
    final String source = "abc";
    final String target = "acdbc";

    Assert.assertEquals(-1, obj.shortestWay(source, target));
  }

  @Test
  public void testScenario3() {
    final String source = "xyz";
    final String target = "xzyxz";

    Assert.assertEquals(3, obj.shortestWay(source, target));
  }
}
