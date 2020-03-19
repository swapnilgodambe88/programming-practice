/** */
package com.programming.practice.problems.misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link GroupAnagrams}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class GroupAnagramsTest {

  private final GroupAnagrams obj = new GroupAnagrams();

  @Test
  public void testScenario1() {
    final String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};

    final List<List<String>> expectedGrouping = new LinkedList<>();

    expectedGrouping.add(Arrays.asList("eat", "tea", "ate"));
    expectedGrouping.add(Arrays.asList("tan", "nat"));
    expectedGrouping.add(Arrays.asList("bat"));

    Assert.assertEquals(expectedGrouping, obj.groupAnagrams(strs));
  }
}
