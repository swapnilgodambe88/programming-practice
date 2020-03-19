package com.programming.practice.datastructure;

import com.programming.practice.problems.binarytree.test.util.BinaryTreeTestUtil;
import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BinarySearchTree}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BinarySearchTreeTest {

  private final BinarySearchTree obj = new BinarySearchTree();

  @Test
  public void testCreateBinaryTree() {
    final TreeNode rootNode = obj.createBinaryTree(Arrays.asList(6, 18, 3));

    BinaryTreeTestUtil.assertNode(6, 3, 18, rootNode);
  }

  @Test
  public void testScenario1() {
    obj.createBinaryTree(Arrays.asList(6, 14, 3, 5, 2, 13, 30, 4));

    BinaryTreeTestUtil.assertOptionalNode(6, 3, 14, obj.BFSSearch(6));
    BinaryTreeTestUtil.assertOptionalNode(3, 2, 5, obj.BFSSearch(3));
    BinaryTreeTestUtil.assertOptionalNode(14, 13, 30, obj.BFSSearch(14));
    BinaryTreeTestUtil.assertOptionalNode(2, null, null, obj.BFSSearch(2));
    BinaryTreeTestUtil.assertOptionalNode(5, 4, null, obj.BFSSearch(5));
    BinaryTreeTestUtil.assertOptionalNode(13, null, null, obj.BFSSearch(13));
    BinaryTreeTestUtil.assertOptionalNode(30, null, null, obj.BFSSearch(30));
  }

  @Test
  public void testCreateBinaryTreeThrowsExceptionForNullNode() {

    Assert.assertThrows(
        "Null node provided as root for the binary tree",
        IllegalArgumentException.class,
        () -> {
          final List<Integer> nodes = new ArrayList<>();
          nodes.add(null);
          obj.createBinaryTree(nodes);
        });
  }
}
