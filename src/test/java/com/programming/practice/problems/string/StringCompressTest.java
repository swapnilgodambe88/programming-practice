package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link StringCompress}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class StringCompressTest {

  private final StringCompress obj = new StringCompress();

  @Test
  public void testScenario1() {
    final char[] chars = new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

    Assert.assertEquals(6, obj.compress(chars));
  }

  @Test
  public void testSingleCharacter() {
    final char[] chars = new char[] {'a'};

    Assert.assertEquals(1, obj.compress(chars));
  }

  @Test
  public void testScenario2() {
    final char[] chars =
        new char[] {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};

    Assert.assertEquals(4, obj.compress(chars));
  }

  @Test
  public void testScenario3() {
    final char[] chars = new char[] {'a', 'a', 'a', 'b', 'b', 'a', 'a'};

    Assert.assertEquals(6, obj.compress(chars));
  }
}
