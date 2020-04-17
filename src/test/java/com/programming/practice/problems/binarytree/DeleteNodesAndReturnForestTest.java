package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link DeleteNodesAndReturnForest}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class DeleteNodesAndReturnForestTest {

  private final DeleteNodesAndReturnForest obj = new DeleteNodesAndReturnForest();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testScenario1() {
    final TreeNode originalTree = tree.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

    final TreeNode expectedRootNode1 = tree.createBinaryTree(Arrays.asList(1, 2, null, 4));
    final TreeNode expectedRootNode2 = tree.createBinaryTree(Arrays.asList(6));
    final TreeNode expectedRootNode3 = tree.createBinaryTree(Arrays.asList(7));

    final List<TreeNode> expectedForest =
        Arrays.asList(expectedRootNode1, expectedRootNode2, expectedRootNode3);
    Assert.assertEquals(expectedForest, obj.delNodes(originalTree, new int[] {3, 5}));
  }

  @Test
  public void testScenario2() {
    final TreeNode originalTree = tree.createBinaryTree(Arrays.asList(1, 2, null, 4, 3));

    final TreeNode expectedRootNode1 = tree.createBinaryTree(Arrays.asList(1));
    final TreeNode expectedRootNode2 = tree.createBinaryTree(Arrays.asList(4));

    final List<TreeNode> expectedForest = Arrays.asList(expectedRootNode1, expectedRootNode2);
    Assert.assertEquals(expectedForest, obj.delNodes(originalTree, new int[] {2, 3}));
  }

  @Test
  public void testNodeNotFoundException() {
    final TreeNode originalTree = tree.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

    Assert.assertThrows(
        "Node to delete not found on binary tree",
        RuntimeException.class,
        () -> {
          obj.delNodes(originalTree, new int[] {99});
        });
  }
}
