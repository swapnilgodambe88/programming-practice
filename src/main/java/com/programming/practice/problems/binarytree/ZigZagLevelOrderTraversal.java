package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from
 * left to right, then right to left for the next level and alternate between).
 *
 * @see <a href = "https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">Zig zag
 *     level order traversal</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ZigZagLevelOrderTraversal {

  /**
   * Performs zigzag level traversal of the binary tree.
   *
   * @param root The root node of the binary tree.
   * @return The List representing the zigzag order traversal.
   */
  public List<List<Integer>> zigzagLevelOrder(final TreeNode root) {
    final List<List<Integer>> levelOrderList = new ArrayList<>();
    if (root == null) {
      return levelOrderList;
    }

    final Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);
    levelOrderList.add(Arrays.asList(root.val));

    boolean reverseOrder = true;
    while (!queue.isEmpty()) {
      final List<Integer> levelNodes = new ArrayList<>();
      final int levelNodeCount = queue.size();

      for (int i = 0; i < levelNodeCount; ++i) {
        final TreeNode dequeuedNode = queue.remove();

        if (dequeuedNode.left != null) {
          levelNodes.add(dequeuedNode.left.val);
          queue.add(dequeuedNode.left);
        }

        if (dequeuedNode.right != null) {
          levelNodes.add(dequeuedNode.right.val);
          queue.add(dequeuedNode.right);
        }
      }

      if (levelNodes.size() > 0 && reverseOrder) {
        Collections.reverse(levelNodes);
        levelOrderList.add(levelNodes);
      } else if (levelNodes.size() > 0 && !reverseOrder) {
        levelOrderList.add(levelNodes);
      }

      reverseOrder = !reverseOrder;
    }

    return levelOrderList;
  }
}
