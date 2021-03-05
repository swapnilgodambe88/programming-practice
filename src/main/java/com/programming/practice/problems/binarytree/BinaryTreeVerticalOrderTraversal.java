package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.*;

/**
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * <pre>
 * Examples 1:
 *
 * Input: [3,9,20,null,null,15,7]
 *
 *    3
 *   /\
 *  /  \
 *  9  20
 *     /\
 *    /  \
 *   15   7
 *
 * Output:
 *
 * [
 *   [9],
 *   [3,15],
 *   [20],
 *   [7]
 * ]
 * Examples 2:
 *
 * Input: [3,9,8,4,0,1,7]
 *
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *
 * Output:
 *
 * [
 *   [4],
 *   [9],
 *   [3,0,1],
 *   [8],
 *   [7]
 * ]
 * Examples 3:
 *
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
 *
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *     /\
 *    /  \
 *    5   2
 *
 * Output:
 *
 * [
 *   [4],
 *   [9,5],
 *   [3,0,1],
 *   [8,2],
 *   [7]
 * ]
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/binary-tree-vertical-order-traversal/">Binary Tree
 *     Vertical Order Traversal</a>
 */
public final class BinaryTreeVerticalOrderTraversal {

  /**
   * A treemap to store all the nodes at a given vertical level where key = level of the binary tree
   */
  private TreeMap<Integer, List<Integer>> map = new TreeMap<>();

  /**
   * Performs a vertical order traversal of the binary tree.
   *
   * @param root The root of the binary tree.
   * @return The vertical order traversal of the binary tree.
   */
  public List<List<Integer>> verticalOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    map = new TreeMap<>();
    traverseTreeBFS(root);
    return new ArrayList(map.values());
  }

  /**
   * Performs a BFS traversal. Along the traversal, populates the {@link
   * BinaryTreeVerticalOrderTraversal#map}.
   *
   * @param root The root of the binary tree. NOTE: A DFS traversal (by using stack or recursion)
   *     will mess up the order of the nodes on the list. Hence we went with the BFS traversal
   *     approach.
   */
  private void traverseTreeBFS(final TreeNode root) {
    final Queue<TreeNode> nodeQueue = new LinkedList<>();
    final Queue<Integer> levelQueue = new LinkedList<>();

    nodeQueue.add(root);
    levelQueue.add(0);

    while (!nodeQueue.isEmpty()) {
      final TreeNode poppedNode = nodeQueue.remove();
      final int poppedLevel = levelQueue.remove();

      if (!map.containsKey(poppedLevel)) {
        map.put(poppedLevel, new ArrayList<>());
      }

      map.get(poppedLevel).add(poppedNode.val);

      if (poppedNode.left != null) {
        nodeQueue.add(poppedNode.left);
        levelQueue.add(poppedLevel - 1);
      }

      if (poppedNode.right != null) {
        nodeQueue.add(poppedNode.right);
        levelQueue.add(poppedLevel + 1);
      }
    }
  }
}
