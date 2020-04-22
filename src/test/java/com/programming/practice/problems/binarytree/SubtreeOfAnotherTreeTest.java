package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SubtreeOfAnotherTree}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SubtreeOfAnotherTreeTest {

  private final SubtreeOfAnotherTree obj = new SubtreeOfAnotherTree();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testScenario1() {
    final TreeNode s = tree.createBinaryTree(Arrays.asList(3, 4, 5, 1, 2, null, null, 0));
    final TreeNode t = tree.createBinaryTree(Arrays.asList(4, 1, 2));

    Assert.assertFalse(obj.isSubtree(s, t));
  }

  @Test
  public void testScenario2() {
    final TreeNode s = tree.createBinaryTree(Arrays.asList(3, 4, 5, 1, 2, null, null, 0));
    final TreeNode t = tree.createBinaryTree(Arrays.asList(4, 1, 2));

    Assert.assertTrue(obj.isSubtree(s, s));
  }

  @Test
  public void testScenario3() {
    final TreeNode s = tree.createBinaryTree(Arrays.asList(3, 4, 5, 1, 2));
    final TreeNode t = tree.createBinaryTree(Arrays.asList(4, 1, 2));

    Assert.assertTrue(obj.isSubtree(s, t));
  }
}
