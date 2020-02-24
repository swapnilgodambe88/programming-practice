package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have
 * the same value.
 *
 * @see <a href = "https://leetcode.com/problems/same-tree/">Same Tree</a>
 * @author Swapnil Godambe.<br>
 *         Copyright 2020.
 */
final class SameTree {

  /**
   * Checks if two binary trees are same or not.
   *
   * @param root1 The root node of tree 1.
   * @param root2 The root node of tree 2.
   * @return True If both trees are same, otherwise false.
   */
  public boolean isSameTree(final TreeNode root1, final TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }

    if (root1 == null || root2 == null) {
      return false;
    }

    return (root1.val == root2.val)
        && isSameTree(root1.left, root2.left)
        && isSameTree(root1.right, root2.right);
  }
}
