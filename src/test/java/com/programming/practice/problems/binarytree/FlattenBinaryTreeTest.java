package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link FlattenBinaryTree}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class FlattenBinaryTreeTest {

  private final FlattenBinaryTree obj = new FlattenBinaryTree();
  private final BinaryTree tree1 = new BinaryTree();
  private final BinaryTree tree2 = new BinaryTree();

  /**
   * Performs assertion that the tree is flat.
   *
   * @param root The root of the tree.
   * @param expectedNodeCount The expected number of nodes.
   */
  private static void assertTreeIsFlat(final TreeNode root, final int expectedNodeCount) {
    if (root != null) {

      int actualNodeCount = 1;
      TreeNode currNode = root;

      while (currNode.right != null) {
        ++actualNodeCount;
        Assert.assertNull(root.left);
        currNode = currNode.right;
      }

      Assert.assertEquals(expectedNodeCount, actualNodeCount);
    }
  }

  @Test
  public void testEmptyTree() {
    obj.flatten1(tree1.getRootNode());
    assertTreeIsFlat(tree1.getRootNode(), 6);

    obj.flatten2(tree2.getRootNode());
    assertTreeIsFlat(tree2.getRootNode(), 6);
  }

  @Test
  public void testScenario1() {
    final List<Integer> nodeList = Arrays.asList(1, 2, 5, 3, 4, null, 6);

    final TreeNode root1 = tree1.createBinaryTree(nodeList);
    obj.flatten1(root1);
    assertTreeIsFlat(root1, 6);

    final TreeNode root2 = tree2.createBinaryTree(nodeList);
    obj.flatten2(root2);
    assertTreeIsFlat(root2, 6);
  }

  @Test
  public void testScenario2() {
    final List<Integer> nodeList =
        Arrays.asList(11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

    final TreeNode root1 = tree1.createBinaryTree(nodeList);
    obj.flatten1(root1);
    assertTreeIsFlat(root1, 15);

    final TreeNode root2 = tree2.createBinaryTree(nodeList);
    obj.flatten2(root2);
    assertTreeIsFlat(root2, 15);
  }
}
