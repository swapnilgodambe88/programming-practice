package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;

/**
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the
 * left and right child subtrees.
 *
 * <p>A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y
 * after some number of flip operations.
 *
 * <p>Write a function that determines whether two binary trees are flip equivalent. The trees are
 * given by root nodes root1 and root2.
 *
 * <pre>
 * Example 1:
 *
 * Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 * Output: true
 * Explanation: We flipped at nodes with values 1, 3, and 5.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/flip-equivalent-binary-trees/">Flip Equivalent
 *     Binary Trees</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company Google
 */
public final class FlipEquivalentBinaryTrees {

  /**
   * Determines if both the trees are flip equivalent.
   *
   * @param root1 The root node of tree1.
   * @param root2 The root node of tree2.
   * @return True If both the trees are flip equivalent. Otherwise, false.
   */
  public boolean flipEquiv(final TreeNode root1, final TreeNode root2) {
    if (root1 == root2) return true;
    if (root1 == null || root2 == null || root1.val != root2.val) return false;

    return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
        || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
  }
}
