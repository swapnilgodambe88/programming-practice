package com.programming.practice.datastructure;

import com.programming.practice.problems.binarytree.test.util.BinaryTreeTestUtil;
import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BinaryTree}
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BinaryTreeTest {

  private final BinaryTree obj = new BinaryTree();

  @Test
  public void testCreateBinaryTree() {
    final TreeNode rootNode = obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    BinaryTreeTestUtil.assertNode(1, 2, 3, rootNode);
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

  @Test
  public void testBFSSearchOnNullTree() {
    Assert.assertEquals(Optional.empty(), obj.BFSSearch(10));
  }

  @Test
  public void testBFSSearchOnNonExistantValue() {
    obj.addNodeToTree(14);

    Assert.assertEquals(Optional.empty(), obj.BFSSearch(199));
  }

  @Test
  public void testBFSSearch() {
    obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    BinaryTreeTestUtil.assertOptionalNode(1, 2, 3, obj.BFSSearch(1));
    BinaryTreeTestUtil.assertOptionalNode(2, 4, 5, obj.BFSSearch(2));
    BinaryTreeTestUtil.assertOptionalNode(3, 6, 7, obj.BFSSearch(3));
    BinaryTreeTestUtil.assertOptionalNode(4, 8, 9, obj.BFSSearch(4));
    BinaryTreeTestUtil.assertOptionalNode(5, 10, null, obj.BFSSearch(5));
    BinaryTreeTestUtil.assertOptionalNode(6, null, null, obj.BFSSearch(6));
    BinaryTreeTestUtil.assertOptionalNode(7, null, null, obj.BFSSearch(7));
    BinaryTreeTestUtil.assertOptionalNode(8, null, null, obj.BFSSearch(8));
    BinaryTreeTestUtil.assertOptionalNode(9, null, null, obj.BFSSearch(9));
    BinaryTreeTestUtil.assertOptionalNode(10, null, null, obj.BFSSearch(10));
  }

  @Test
  public void testBFSSearchWithSomeNodesNull() {
    obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, null, 6, 7, null, 9));

    BinaryTreeTestUtil.assertOptionalNode(1, 2, 3, obj.BFSSearch(1));
    BinaryTreeTestUtil.assertOptionalNode(2, 4, null, obj.BFSSearch(2));
    BinaryTreeTestUtil.assertOptionalNode(3, 6, 7, obj.BFSSearch(3));
    BinaryTreeTestUtil.assertOptionalNode(4, null, 9, obj.BFSSearch(4));
    BinaryTreeTestUtil.assertOptionalNode(6, null, null, obj.BFSSearch(6));
    BinaryTreeTestUtil.assertOptionalNode(7, null, null, obj.BFSSearch(7));
    BinaryTreeTestUtil.assertOptionalNode(9, null, null, obj.BFSSearch(9));
  }

  @Test
  public void testDFSSearchOnNullTree() {
    Assert.assertEquals(Optional.empty(), obj.DFSSearch(10));
  }

  @Test
  public void testDFSSearchOnNonExistantValue() {
    obj.addNodeToTree(14);

    Assert.assertEquals(Optional.empty(), obj.DFSSearch(199));
  }

  @Test
  public void testDFSSearch() {
    obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    BinaryTreeTestUtil.assertOptionalNode(1, 2, 3, obj.DFSSearch(1));
    BinaryTreeTestUtil.assertOptionalNode(2, 4, 5, obj.DFSSearch(2));
    BinaryTreeTestUtil.assertOptionalNode(3, 6, 7, obj.DFSSearch(3));
    BinaryTreeTestUtil.assertOptionalNode(4, 8, 9, obj.DFSSearch(4));
    BinaryTreeTestUtil.assertOptionalNode(5, 10, null, obj.DFSSearch(5));
    BinaryTreeTestUtil.assertOptionalNode(6, null, null, obj.DFSSearch(6));
    BinaryTreeTestUtil.assertOptionalNode(7, null, null, obj.DFSSearch(7));
    BinaryTreeTestUtil.assertOptionalNode(8, null, null, obj.DFSSearch(8));
    BinaryTreeTestUtil.assertOptionalNode(9, null, null, obj.DFSSearch(9));
    BinaryTreeTestUtil.assertOptionalNode(10, null, null, obj.DFSSearch(10));
  }

  @Test
  public void testDFSSearchWithSomeNodesNull() {
    obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, null, 6, 7, null, 9));

    BinaryTreeTestUtil.assertOptionalNode(1, 2, 3, obj.DFSSearch(1));
    BinaryTreeTestUtil.assertOptionalNode(2, 4, null, obj.DFSSearch(2));
    BinaryTreeTestUtil.assertOptionalNode(3, 6, 7, obj.DFSSearch(3));
    BinaryTreeTestUtil.assertOptionalNode(4, null, 9, obj.DFSSearch(4));
    BinaryTreeTestUtil.assertOptionalNode(6, null, null, obj.DFSSearch(6));
    BinaryTreeTestUtil.assertOptionalNode(7, null, null, obj.DFSSearch(7));
    BinaryTreeTestUtil.assertOptionalNode(9, null, null, obj.DFSSearch(9));
  }

  @Test
  public void testTraversal() {
    // Tests that no exception is thrown while performing the traversal

    obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, null, 6, 7, null, 9));

    obj.inOrderTraversal();
    obj.preOrderTraversal();
    obj.postOrderTraversal();
  }
}
