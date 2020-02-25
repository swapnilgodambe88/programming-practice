package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * <p>For this problem, a height-balanced binary tree is defined as:
 *
 * <p>a binary tree in which the left and right subtrees of every node differ in height by no more
 * than 1.
 *
 * <p>Example 1:
 *
 * <p>Given the following tree [3,9,20,null,null,15,7]: Return true.
 *
 * <p>Example 2:
 *
 * <p>Given the following tree [1,2,2,3,3,null,null,4,4]: Return false
 *
 * @see <a href = "https://leetcode.com/problems/balanced-binary-tree/">Balanced Binary Tree</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class BalancedTree {

  private final MaximumDepth maximumDepth = new MaximumDepth();

  /**
   * Checks whether a tree is balanced or not.
   *
   * @param root The root of the tree.
   * @return True If the tree is balanced, otherwise false.
   */
  public boolean isBalanced(final TreeNode root) {

    if (root == null) {
      return true;
    }

    if (isHeightEqualOrDifferingBy1(root.left, root.right)) {
      // Perform recursive isBalanced call for successive node of the root. If either one is false,
      // a false would be returned
      return isBalanced(root.left) && isBalanced(root.right);
    }

    return false;
  }

  /**
   * Checks if the height of the two tree is equal or differ by 1.
   *
   * @param t1 The root node of tree 1.
   * @param t2 The root node of tree 2.
   * @return True If the height of both trees are same or differ by 1, otherwise false.
   */
  private boolean isHeightEqualOrDifferingBy1(final TreeNode t1, final TreeNode t2) {
    final int leftHeight = maximumDepth.maxDepth(t1);
    final int rightHeight = maximumDepth.maxDepth(t2);

    if (Math.abs(leftHeight - rightHeight) == 1 || leftHeight == rightHeight) {
      return true;
    }

    return false;
  }
}
