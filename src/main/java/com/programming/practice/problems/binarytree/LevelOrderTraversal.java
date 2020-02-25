package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to
 * right, level by level).
 *
 * @see <a href = "https://leetcode.com/problems/binary-tree-level-order-traversal/">Binary Tree
 *     Level Order Traversal</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class LevelOrderTraversal {

  /**
   * Performs level order traversal on the binary tree.
   *
   * @param root The root node of the binary tree.
   * @return The level order traversal of tree.
   */
  public List<List<Integer>> levelOrder(final TreeNode root) {

    final List<List<Integer>> levelOrderList = new ArrayList<>();
    if (root == null) {
      return levelOrderList;
    }

    final Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);
    levelOrderList.add(Arrays.asList(root.val));

    while (!queue.isEmpty()) {

      final List<Integer> levelList = new ArrayList<>();
      final int levelNodeCount = queue.size();

      for (int i = 0; i < levelNodeCount; ++i) {
        final TreeNode dequeuedNode = queue.remove();

        if (dequeuedNode.left != null) {
          levelList.add(dequeuedNode.left.val);
          queue.add(dequeuedNode.left);
        }

        if (dequeuedNode.right != null) {
          levelList.add(dequeuedNode.right.val);
          queue.add(dequeuedNode.right);
        }
      }

      if (levelList.size() > 0) {
        levelOrderList.add(levelList);
      }
    }

    return levelOrderList;
  }
}
