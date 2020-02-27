package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White tests for {@link PathSum}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class PathSumTest {

  private final PathSum obj = new PathSum();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testSolutionExists() {
    final TreeNode root =
        tree.createBinaryTree(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 1));

    Assert.assertTrue(obj.hasPathSum(root, 22));
  }

  @Test
  public void testNoSolutionExists1() {
    final TreeNode root =
        tree.createBinaryTree(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 1));

    Assert.assertFalse(obj.hasPathSum(root, 100));
  }

  @Test
  public void testNoSolutionExists2() {
    final TreeNode root =
        tree.createBinaryTree(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 1));

    Assert.assertFalse(obj.hasPathSum(root, 9));
  }
}
