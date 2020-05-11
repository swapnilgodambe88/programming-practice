package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link FindAndReplaceInString}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class FindAndReplaceInStringTest {

  private final FindAndReplaceInString obj = new FindAndReplaceInString();

  @Test
  public void testScenario1() {
    final String S = "abcd";
    final int[] indexes = new int[] {0, 2};
    final String[] sources = new String[] {"a", "cd"};
    final String[] targets = new String[] {"eee", "ffff"};

    Assert.assertEquals("eeebffff", obj.findReplaceString(S, indexes, sources, targets));
  }

  @Test
  public void testScenario2() {
    final String S = "abcd";
    final int[] indexes = new int[] {0, 2};
    final String[] sources = new String[] {"ab", "ec"};
    final String[] targets = new String[] {"eee", "ffff"};

    Assert.assertEquals("eeecd", obj.findReplaceString(S, indexes, sources, targets));
  }

  @Test
  public void testScenario3() {
    final String S = "vmokgggqzp";
    final int[] indexes = new int[] {3, 5, 1};
    final String[] sources = new String[] {"kg", "ggq", "mo"};
    final String[] targets = new String[] {"s", "so", "bfr"};

    Assert.assertEquals("vbfrssozp", obj.findReplaceString(S, indexes, sources, targets));
  }
}
