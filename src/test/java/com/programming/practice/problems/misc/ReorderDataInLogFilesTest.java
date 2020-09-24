package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ReorderDataInLogFiles}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ReorderDataInLogFilesTest {

  private final ReorderDataInLogFiles obj = new ReorderDataInLogFiles();

  @Test
  public void testScenario1() {
    final String[] logs =
        new String[] {
          "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"
        };

    final String[] expectedSortedLogs =
        new String[] {
          "let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"
        };

    Assert.assertArrayEquals(expectedSortedLogs, obj.reorderLogFiles(logs));
  }
}
