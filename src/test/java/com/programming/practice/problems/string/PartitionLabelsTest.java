package com.programming.practice.problems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link PartitionLabels}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class PartitionLabelsTest {

  private final PartitionLabels obj = new PartitionLabels();

  @Test
  public void testScenario1() {
    final List<Integer> expectedPartition = Arrays.asList(9, 7, 8);

    Assert.assertEquals(expectedPartition, obj.partitionLabels("ababcbacadefegdehijhklij"));
  }

  @Test
  public void testUniqueCharacters() {
    final List<Integer> expectedPartition = Arrays.asList(1, 1, 1, 1, 1);

    Assert.assertEquals(expectedPartition, obj.partitionLabels("abcde"));
  }

  @Test
  public void testAllSameCharacters() {
    final List<Integer> expectedPartition = Arrays.asList(5);

    Assert.assertEquals(expectedPartition, obj.partitionLabels("aaaaa"));
  }

  @Test
  public void testSingleCharacter() {
    final List<Integer> expectedPartition = Arrays.asList(1);

    Assert.assertEquals(expectedPartition, obj.partitionLabels("a"));
  }

  @Test
  public void testEmptyString() {
    final List<Integer> expectedPartition = new ArrayList<>();

    Assert.assertEquals(expectedPartition, obj.partitionLabels(""));
  }
}
