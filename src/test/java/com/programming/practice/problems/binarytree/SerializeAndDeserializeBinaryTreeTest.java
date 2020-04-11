package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SerializeAndDeserializeBinaryTree}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SerializeAndDeserializeBinaryTreeTest {

  private final SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testScenario1() {
    tree.createBinaryTree(Arrays.asList(-1, 0, 1));

    final String expectedSerializedBinaryTree = "-1#0$1|0#null$null|1#null$null|";

    Assert.assertEquals(expectedSerializedBinaryTree, obj.serialize(tree.getRootNode()));
    Assert.assertEquals(tree.getRootNode(), obj.deserialize(expectedSerializedBinaryTree));
  }

  @Test
  public void testScenario2() {
    tree.createBinaryTree(Arrays.asList(1, 2, 3, null, null, 4, 5));

    final String expectedSerializedBinaryTree = "1#2$3|2#null$null|3#4$5|4#null$null|5#null$null|";

    Assert.assertEquals(expectedSerializedBinaryTree, obj.serialize(tree.getRootNode()));
    Assert.assertEquals(tree.getRootNode(), obj.deserialize(expectedSerializedBinaryTree));
  }
}
