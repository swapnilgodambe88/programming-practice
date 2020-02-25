package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class BalancedTreeTest {

  private final BalancedTree obj = new BalancedTree();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testBalancedTree() {
    tree.createBinaryTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
    Assert.assertTrue(obj.isBalanced(tree.getRootNode()));
  }

  @Test
  public void testEmptyTree() {
    Assert.assertTrue(obj.isBalanced(tree.getRootNode()));
  }

  @Test
  public void testNotBalancedTree() {
    tree.createBinaryTree(Arrays.asList(1, 2, 2, 3, 3, null, null, 4, 4));
    Assert.assertFalse(obj.isBalanced(tree.getRootNode()));
  }

  @Test
  public void testSingleNodeTree() {
    tree.addNodeToBinaryTree(8);
    Assert.assertTrue(obj.isBalanced(tree.getRootNode()));
  }
}
