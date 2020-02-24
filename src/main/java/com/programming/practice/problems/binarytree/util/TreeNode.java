package com.programming.practice.problems.binarytree.util;

import java.util.Objects;

/**
 * A node representation of a Tree.
 *
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
public final class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  /**
   * Constructor for {@link TreeNode}.
   *
   * @param val The value of the node.
   */
  public TreeNode(int val) {
    this.val = val;
  }

  /** {@inheritDoc} */
  public String toString() {
    final String leftVal = this.left == null ? "null" : Integer.toString(this.left.val);
    final String rightVal = this.right == null ? "null" : Integer.toString(this.right.val);

    return "Data: " + this.val + " | leftChild: " + leftVal + " | rightChild: " + rightVal;
  }

  /** {@inheritDoc} */
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof TreeNode)) {
      return false;
    }

    final TreeNode other = (TreeNode) object;
    if (val != other.val) {
      return false;
    }

    if (!(Objects.equals(this.left, other.left))) {
      return false;
    }

    if (!(Objects.equals(this.right, other.right))) {
      return false;
    }

    return true;
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode() {
    return Objects.hash(val, left, right);
  }

  /**
   * @param node The node to validate (must be non-null).
   * @return True if the node is leaf node. otherwise false.
   * @throws NullPointerException If the node supplied is null.
   */
  public static boolean isLeafNode(final TreeNode node) {
    Objects.requireNonNull(node, "Node provided is null");

    return node.left == null && node.right == null;
  }
}
