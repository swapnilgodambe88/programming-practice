package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value
 * in the range [low, high].
 *
 * <pre>
 * Example 1:
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 *
 * Example 2:
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href =
 *     "https://leetcode.com/problems/range-sum-of-bst/">https://leetcode.com/problems/range-sum-of-bst/</a>
 */
public class RangeSumBST {

  /**
   * Given the root node of a binary search tree, return the sum of values of all nodes with a value
   * in the range [low, high].
   *
   * @param root The root node.
   * @param low The low range.
   * @param high The high range.
   * @return The sum of the values of all nodes with a value in the range [low, high].
   */
  public int rangeSumBST(final TreeNode root, final int low, final int high) {
    int sum = 0;

    if (root == null) {
      return sum;
    }

    final Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      final TreeNode node = queue.remove();

      if (node.val >= low && node.val <= high) {
        sum += node.val;
      }

      if (node.left != null) {
        queue.add(node.left);
      }

      if (node.right != null) {
        queue.add(node.right);
      }
    }

    return sum;
  }
}
