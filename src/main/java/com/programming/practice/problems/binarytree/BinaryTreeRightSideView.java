package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the
 * nodes you can see ordered from top to bottom.
 *
 * <p>Example:
 *
 * <p>Input: [1,2,3,null,5,null,4] Output: [1, 3, 4]
 *
 * @see <a href = "https://leetcode.com/problems/binary-tree-right-side-view/">Binary Tree Right
 *     Side View</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class BinaryTreeRightSideView {

  /**
   * Returns the values of the nodes you can see ordered from top to bottom.
   *
   * @param root The root of the binary tree.
   * @return The values of the nodes you can see ordered from top to bottom.
   */
  public List<Integer> rightSideView(final TreeNode root) {

    if (root == null) {
      return new ArrayList<>();
    }
    final Queue<TreeNode> queue = new LinkedList<>();
    final List<Integer> rightSideView = new ArrayList<>();

    rightSideView.add(root.val);

    queue.add(root);
    while (!queue.isEmpty()) {

      final int numberOfNodesOnExistingLevel = queue.size();

      int lastNodeInsertedInQueue = Integer.MIN_VALUE;
      for (int i = 0; i < numberOfNodesOnExistingLevel; ++i) {
        final TreeNode poppedNode = queue.remove();

        if (poppedNode.left != null) {
          queue.add(poppedNode.left);
          lastNodeInsertedInQueue = poppedNode.left.val;
        }

        if (poppedNode.right != null) {
          queue.add(poppedNode.right);
          lastNodeInsertedInQueue = poppedNode.right.val;
        }
      }

      if (lastNodeInsertedInQueue != Integer.MIN_VALUE) {
        rightSideView.add(lastNodeInsertedInQueue);
      }
    }

    return rightSideView;
  }
}
