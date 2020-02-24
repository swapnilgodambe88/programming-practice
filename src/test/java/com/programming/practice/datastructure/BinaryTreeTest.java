package com.programming.practice.datastructure;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * White box tests for {@link BinaryTree}
 *
 * <p>Copyright 2020.<br>
 *
 * @author Swapnil Godambe.
 */
public final class BinaryTreeTest {

  @Rule public final ExpectedException exceptionRule = ExpectedException.none();

  private final BinaryTree obj = new BinaryTree();

  /**
   * Performs assertion on the optional node and it's value.
   *
   * @param expectedVal The expected value on the node.
   * @param expectedLeft The expected integer value of the left node (null if left node is null).
   * @param expectedRight The expected integer value of the right node (null if right node is null).
   * @param actualNode The actual {@link TreeNode} to assert.
   */
  private static void assertOptionalNode(
      final int expectedVal,
      final Integer expectedLeft,
      final Integer expectedRight,
      final Optional<TreeNode> actualNode) {

    Assert.assertTrue(actualNode.isPresent());
    assertNode(expectedVal, expectedLeft, expectedRight, actualNode.get());
  }

  /**
   * Performs assertion on the node value.
   *
   * @param expectedVal The expected value on the node.
   * @param expectedLeft The expected integer value of the left node (null if left node is null).
   * @param expectedRight The expected integer value of the right node (null if right node is null).
   * @param actualNode The actual {@link TreeNode} to assert.
   */
  private static void assertNode(
      final int expectedVal,
      final Integer expectedLeft,
      final Integer expectedRight,
      final TreeNode actualNode) {

    Assert.assertNotNull("Node not expected to be null", actualNode);

    final String expectedNodeToString =
        "Data: "
            + expectedVal
            + " | leftChild: "
            + (expectedLeft == null ? "null" : Integer.toString(expectedLeft))
            + " | rightChild: "
            + (expectedRight == null ? "null" : Integer.toString(expectedRight));

    Assert.assertTrue(expectedNodeToString.equals(actualNode.toString()));
  }

  @Test
  public void testCreateBinaryTree() {
    final TreeNode rootNode = obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    assertNode(1, 2, 3, rootNode);
  }

  @Test
  public void testCreateBinaryTreeThrowsExceptionForNullNode() {
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("Null node provided as root for the binary tree");

    final List<Integer> nodes = new ArrayList<>();
    nodes.add(null);
    obj.createBinaryTree(nodes);
  }

  @Test
  public void testBFSSearch() {
    obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    assertOptionalNode(1, 2, 3, obj.BFSSearch(1));
    assertOptionalNode(2, 4, 5, obj.BFSSearch(2));
    assertOptionalNode(3, 6, 7, obj.BFSSearch(3));
    assertOptionalNode(4, 8, 9, obj.BFSSearch(4));
    assertOptionalNode(5, 10, null, obj.BFSSearch(5));
    assertOptionalNode(6, null, null, obj.BFSSearch(6));
    assertOptionalNode(7, null, null, obj.BFSSearch(7));
    assertOptionalNode(8, null, null, obj.BFSSearch(8));
    assertOptionalNode(9, null, null, obj.BFSSearch(9));
    assertOptionalNode(10, null, null, obj.BFSSearch(10));
  }

  @Test
  public void testBFSSearchWithSomeNodesNull() {
    obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, null, 6, 7, null, 9));

    assertOptionalNode(1, 2, 3, obj.BFSSearch(1));
    assertOptionalNode(2, 4, null, obj.BFSSearch(2));
    assertOptionalNode(3, 6, 7, obj.BFSSearch(3));
    assertOptionalNode(4, null, 9, obj.BFSSearch(4));
    assertOptionalNode(6, null, null, obj.BFSSearch(6));
    assertOptionalNode(7, null, null, obj.BFSSearch(7));
    assertOptionalNode(9, null, null, obj.BFSSearch(9));
  }

  @Test
  public void testDFSSearch() {
    obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    assertOptionalNode(1, 2, 3, obj.DFSSearch(1));
    assertOptionalNode(2, 4, 5, obj.DFSSearch(2));
    assertOptionalNode(3, 6, 7, obj.DFSSearch(3));
    assertOptionalNode(4, 8, 9, obj.DFSSearch(4));
    assertOptionalNode(5, 10, null, obj.DFSSearch(5));
    assertOptionalNode(6, null, null, obj.DFSSearch(6));
    assertOptionalNode(7, null, null, obj.DFSSearch(7));
    assertOptionalNode(8, null, null, obj.DFSSearch(8));
    assertOptionalNode(9, null, null, obj.DFSSearch(9));
    assertOptionalNode(10, null, null, obj.DFSSearch(10));
  }

  @Test
  public void testDFSSearchWithSomeNodesNull() {
    obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, null, 6, 7, null, 9));

    assertOptionalNode(1, 2, 3, obj.DFSSearch(1));
    assertOptionalNode(2, 4, null, obj.DFSSearch(2));
    assertOptionalNode(3, 6, 7, obj.DFSSearch(3));
    assertOptionalNode(4, null, 9, obj.DFSSearch(4));
    assertOptionalNode(6, null, null, obj.DFSSearch(6));
    assertOptionalNode(7, null, null, obj.DFSSearch(7));
    assertOptionalNode(9, null, null, obj.DFSSearch(9));
  }
}
