package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and
 * node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this
 * node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * @see <a href = "https://leetcode.com/problems/subtree-of-another-tree/submissions/">Subtree of
 *     Another Tree</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SubtreeOfAnotherTree {

  /**
   * Given two non-empty binary trees s and t, checks whether tree t has exactly the same structure
   * and node values with a subtree of s.
   *
   * @param s The root node of s tree.
   * @param t The root node of 5 tree.
   * @return True If t is subtree of s. Otherwise, false.
   */
  public boolean isSubtree(final TreeNode s, final TreeNode t) {
    if (isIdentical(s, t)) {
      return true;
    }

    return (s.left != null && isSubtree(s.left, t)) || (s.right != null && isSubtree(s.right, t));
  }

  /**
   * Recursive method to check if both t1 and t2 trees are identical.
   *
   * @param t1 The root node of t1.
   * @param t2 The root node of t2.
   * @return True If both the trees are identical. Otherwise, false.
   */
  private static boolean isIdentical(final TreeNode t1, final TreeNode t2) {
    if (areBothNodesNull(t1, t2) || areBothNodesLeafNodesAndEqual(t1, t2)) {
      return true;
    }

    // One of the node is null and other is non-null OR both node values are different
    if (t1 == null || t2 == null || t1.val != t2.val) {
      return false;
    }

    return isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
  }

  /**
   * @param t1 The root node of t1.
   * @param t2 The root node of t2.
   * @return True If both nodes are leaf nodes and equal. Otherwise, false.
   */
  private static boolean areBothNodesLeafNodesAndEqual(final TreeNode t1, final TreeNode t2) {
    if (t1 != null
        && t1.left == null
        && t1.right == null
        && t2 != null
        && t2.left == null
        && t2.right == null
        && t1.val == t2.val) {
      return true;
    }

    return false;
  }

  /**
   * @param t1 The root node of t1.
   * @param t2 The root node of t2.
   * @return True If both nodes are null. Otherwise, false.
   */
  private static boolean areBothNodesNull(final TreeNode t1, final TreeNode t2) {
    return (t1 == null && t2 == null);
  }
}
