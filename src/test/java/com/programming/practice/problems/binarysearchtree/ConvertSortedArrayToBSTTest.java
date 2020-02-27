package com.programming.practice.problems.binarysearchtree;

import com.programming.practice.problems.binarytree.BalancedTree;
import com.programming.practice.problems.binarytree.util.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ConvertSortedArrayToBST}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class ConvertSortedArrayToBSTTest {

  private final ConvertSortedArrayToBST obj = new ConvertSortedArrayToBST();
  private final BalancedTree balancedTree = new BalancedTree();

  @Test
  public void testEmptyTree() {

    final TreeNode root = obj.sortedArrayToBST(new int[] {});

    Assert.assertNull(root);
    Assert.assertTrue(balancedTree.isBalanced(root));
  }

  @Test
  public void testSingleNodeTree() {
    final TreeNode root = obj.sortedArrayToBST(new int[] {1});

    Assert.assertNotNull(root);
    Assert.assertTrue(balancedTree.isBalanced(root));
  }

  @Test
  public void testFullBinaryTree() {
    final TreeNode root = obj.sortedArrayToBST(new int[] {-10, -3, 0, 5, 9});

    Assert.assertNotNull(root);
    Assert.assertTrue(balancedTree.isBalanced(root));
  }
}
