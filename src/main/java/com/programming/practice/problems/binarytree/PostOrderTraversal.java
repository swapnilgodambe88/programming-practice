package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * <pre>
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/binary-tree-postorder-traversal/">Binary Tree *
 *     Postorder Traversal</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2024.
 */
public final class PostOrderTraversal {

  /** Member variable to hold traversal values. */
  private final List<Integer> traversalNodes = new ArrayList<>();

  /**
   * @param root The root node.
   * @return The list representing the post-order traversal.
   */
  public List<Integer> postorderTraversal(final TreeNode root) {
    postOrderTraversalRecursive(root);
    return traversalNodes;
  }

  /**
   * Recursive function to perform post-order traversal.
   *
   * @param node The root node.
   */
  private void postOrderTraversalRecursive(final TreeNode node) {
    if (node != null) {
      postOrderTraversalRecursive(node.left);
      postOrderTraversalRecursive(node.right);
      traversalNodes.add(node.val);
    }
  }
}
