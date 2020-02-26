package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MaximumDepth}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class MaximumDepthTest {

  private final MaximumDepth obj = new MaximumDepth();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testEmptyTree() {
    Assert.assertEquals(0, obj.maxDepth(tree.getRootNode()));
  }

  @Test
  public void testEvenSizedBinaryTree() {
    tree.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
    Assert.assertEquals(4, obj.maxDepth(tree.getRootNode()));
  }

  @Test
  public void testLeftSidedBinaryTree() {
    tree.createBinaryTree(Arrays.asList(1, 2, null, 4, null, null, null, 8));
    Assert.assertEquals(4, obj.maxDepth(tree.getRootNode()));
  }

  @Test
  public void testRandomBinaryTree() {
    tree.createBinaryTree(Arrays.asList(1, 2, null, null, 4, null, null, null, null, 5));
    Assert.assertEquals(4, obj.maxDepth(tree.getRootNode()));
  }

  @Test
  public void testRightSidedBinaryTree() {
    tree.createBinaryTree(
        Arrays.asList(
            1, null, 3, null, null, null, 7, null, null, null, null, null, null, null, 15));
    Assert.assertEquals(4, obj.maxDepth(tree.getRootNode()));
  }

  @Test
  public void testSingleRootNode() {
    tree.addNodeToTree(9);
    Assert.assertEquals(1, obj.maxDepth(tree.getRootNode()));
  }
}
