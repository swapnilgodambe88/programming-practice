package com.programming.practice.problems.misc;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link DesignSearchAutoComplete}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class DesignSearchAutoCompleteTest {

  @Test
  public void testScenario1() {
    final String[] sentences = new String[] {"i love you", "island", "iroman", "i love leetcode"};
    final int[] times = new int[] {5, 3, 2, 2};

    final DesignSearchAutoComplete obj = new DesignSearchAutoComplete(sentences, times);

    List<String> expectedAutoComplete = Arrays.asList("i love you", "island", "i love leetcode");
    Assert.assertEquals(expectedAutoComplete, obj.input('i'));

    expectedAutoComplete = Arrays.asList("i love you", "i love leetcode");
    Assert.assertEquals(expectedAutoComplete, obj.input(' '));

    expectedAutoComplete = Arrays.asList();
    Assert.assertEquals(expectedAutoComplete, obj.input('a'));

    expectedAutoComplete = Arrays.asList();
    Assert.assertEquals(expectedAutoComplete, obj.input('#'));

    expectedAutoComplete = Arrays.asList("i love you", "island", "i love leetcode");
    Assert.assertEquals(expectedAutoComplete, obj.input('i'));

    expectedAutoComplete = Arrays.asList("i love you", "i love leetcode", "i a");
    Assert.assertEquals(expectedAutoComplete, obj.input(' '));

    expectedAutoComplete = Arrays.asList("i a");
    Assert.assertEquals(expectedAutoComplete, obj.input('a'));

    expectedAutoComplete = Arrays.asList();
    Assert.assertEquals(expectedAutoComplete, obj.input('#'));

    expectedAutoComplete = Arrays.asList("i love you", "island", "i a");
    Assert.assertEquals(expectedAutoComplete, obj.input('i'));

    expectedAutoComplete = Arrays.asList("i love you", "i a", "i love leetcode");
    Assert.assertEquals(expectedAutoComplete, obj.input(' '));

    expectedAutoComplete = Arrays.asList("i a");
    Assert.assertEquals(expectedAutoComplete, obj.input('a'));

    expectedAutoComplete = Arrays.asList();
    Assert.assertEquals(expectedAutoComplete, obj.input('#'));
  }
}
