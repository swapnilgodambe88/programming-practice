package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * <p>According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
 * between two nodes p and q as the lowest node in T that has both p and q as descendants (where we
 * allow a node to be a descendant of itself).”
 *
 * <p>Example 1:
 *
 * <p>Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 Output: 3 Explanation: The LCA of
 * nodes 5 and 1 is 3.
 *
 * <p>Example 2:
 *
 * <p>Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 Output: 5 Explanation: The LCA of
 * nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 * @see <a href = "https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">Lowest
 *     Common Ancestor of a Binary Tree</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class LowestCommonAncentorOfBinaryTree {

  /**
   * Finds the lowest common ancestor (LCA) of the two given nodes in the tree.
   *
   * @param root The root node of the binary tree.
   * @param p The 1st node.
   * @param q The 2nd node.
   * @return The LCA of two nodes.
   */
  public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
    if (root == null) {
      return null;
    }

    if (root.val == p.val || root.val == q.val) {
      return root;
    }

    final TreeNode leftLCA = this.lowestCommonAncestor(root.left, p, q);
    final TreeNode rightLCA = this.lowestCommonAncestor(root.right, p, q);

    if (leftLCA != null && rightLCA != null) {
      return root;
    } else if (leftLCA != null) {
      return leftLCA;
    }

    return rightLCA;
  }
}
