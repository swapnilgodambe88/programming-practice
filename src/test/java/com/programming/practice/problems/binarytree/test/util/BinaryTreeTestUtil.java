package com.programming.practice.problems.binarytree.test.util;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.Optional;
import org.junit.Assert;

/**
 * Utility class for white box tests on binary trees and binary search trees.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BinaryTreeTestUtil {

  /**
   * Constructor for {@link BinaryTreeTestUtil}. Declared private to prevent direct instantiation.
   */
  private BinaryTreeTestUtil() {
    throw new UnsupportedOperationException(
        "Constructor invocation for BinaryTreeTestUtil forbidden");
  }

  /**
   * Performs assertion on the optional node and it's value.
   *
   * @param expectedVal The expected value on the node.
   * @param expectedLeft The expected integer value of the left node (null if left node is null).
   * @param expectedRight The expected integer value of the right node (null if right node is null).
   * @param actualNode The actual {@link TreeNode} to assert.
   */
  public static void assertOptionalNode(
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
  public static void assertNode(
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
}
