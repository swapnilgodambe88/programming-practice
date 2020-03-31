package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White test for {@link LowestCommonAncestorOfBinaryTree}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class LowestCommonAncestorOfBinaryTreeTest {

  private final LowestCommonAncestorOfBinaryTree obj = new LowestCommonAncestorOfBinaryTree();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testScenario1() {
    tree.createBinaryTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));

    final TreeNode expectedLCA = tree.BFSSearch(3).get();
    final TreeNode p = tree.BFSSearch(5).get();
    final TreeNode q = tree.BFSSearch(1).get();

    Assert.assertEquals(expectedLCA, obj.lowestCommonAncestor(tree.getRootNode(), p, q));
  }

  @Test
  public void testScenario2() {
    tree.createBinaryTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));

    final TreeNode expectedLCA = tree.BFSSearch(5).get();
    final TreeNode p = tree.BFSSearch(5).get();
    final TreeNode q = tree.BFSSearch(4).get();

    Assert.assertEquals(expectedLCA, obj.lowestCommonAncestor(tree.getRootNode(), p, q));
  }
}
