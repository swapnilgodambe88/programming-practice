package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * <p>For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 * @see <a href = "https://leetcode.com/problems/symmetric-tree/">Symmetric Tree</a>
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
final class SymmetricTree {

  /**
   * @param root The {@link TreeNode} representing the root node of the binary tree.
   * @return True if the binary tree is symmetric. Otherwise false.
   */
  public boolean isSymmetric(final TreeNode root) {

    // Assumes that a empty tree is symmetric
    if (root == null) {
      return true;
    }
    return isMirror(root.left, root.right);
  }

  /**
   * Recursive function to determine if t1 and t2 are mirror of each other.
   *
   * @param t1 The root node of tree 1.
   * @param t2 The root node of tree 2.
   * @return True If t1 and t2 are symmetric. Otherwise false.
   */
  private boolean isMirror(final TreeNode t1, final TreeNode t2) {
    if (t1 == null && t2 == null) {
      return true;
    }

    if (t1 == null || t2 == null) {
      return false;
    }

    return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
  }
}
