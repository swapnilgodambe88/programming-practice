package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link FlipEquivalentBinaryTrees}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class FlipEquivalentBinaryTreesTest {

  private final FlipEquivalentBinaryTrees obj = new FlipEquivalentBinaryTrees();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testScenario1() {
    final TreeNode root1 =
        tree.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, null, null, null, 7, 8));

    final TreeNode root2 =
        tree.createBinaryTree(
            Arrays.asList(1, 3, 2, null, 6, 4, 5, null, null, null, null, null, null, 8, 7));

    Assert.assertTrue(obj.flipEquiv(root1, root2));
  }

  @Test
  public void testScenario2() {
    final TreeNode root1 = tree.createBinaryTree(Arrays.asList(0, 3, 1, null, null, null, 2));

    final TreeNode root2 = tree.createBinaryTree(Arrays.asList(0, 3, 1, 2));

    Assert.assertFalse(obj.flipEquiv(root1, root2));
  }

  @Test
  public void testScenario3() {
    final TreeNode root1 = tree.createBinaryTree(Arrays.asList(0, null, 1));

    final TreeNode root2 = tree.createBinaryTree(Arrays.asList(0, 1));

    Assert.assertTrue(obj.flipEquiv(root1, root2));
  }
}
