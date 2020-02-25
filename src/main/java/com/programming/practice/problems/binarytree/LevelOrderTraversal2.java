package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from
 * left to right, level by level from leaf to root).
 *
 * <p>For example: Given binary tree [3,9,20,null,null,15,7], return its bottom-up level order
 * traversal as: [ [15,7], [9,20], [3] ]
 *
 * @see <a href = "https://leetcode.com/problems/binary-tree-level-order-traversal-ii/">Binary Tree
 *     Level Order Traversal II</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
final class LevelOrderTraversal2 extends LevelOrderTraversal {

  /**
   * Performs level order traversal on the binary tree in reverse.
   *
   * @param root The root node of the binary tree.
   * @return The level order traversal of tree.
   */
  public List<List<Integer>> levelOrderBottom(final TreeNode root) {
    final List<List<Integer>> levelOrderTraversal = levelOrder(root);

    Collections.reverse(levelOrderTraversal);
    return levelOrderTraversal;
  }
}
