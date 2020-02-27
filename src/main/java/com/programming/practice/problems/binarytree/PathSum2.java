package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given
 * sum.
 *
 * <p>Note: A leaf is a node with no children.
 *
 * @see <a href = "https://leetcode.com/problems/path-sum-ii/">Path Sum II</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class PathSum2 {

  private final List<List<Integer>> sumPath = new ArrayList<>();

  /**
   * Finds all root-to-leaf paths where each path's sum equals the given sum.
   *
   * @param root The root of the tree.
   * @param sum The target sum.
   * @return The list of all path which adds up to the sum.
   */
  public List<List<Integer>> pathSum(final TreeNode root, final int sum) {

    addSum(root, 0, new ArrayList<>(), sum);
    return sumPath;
  }

  /**
   * Recursive function which add the node value to the sumSoFar and checks for equality to sum.
   *
   * @param root The root of the node.
   * @param sumSoFar The sum so far.
   * @param targetSum The target sum.
   */
  private void addSum(
      final TreeNode root, final int sumSoFar, final List<Integer> pathSoFar, final int targetSum) {
    if (root == null) {
      return;
    }

    pathSoFar.add(root.val);

    if (TreeNode.isLeafNode(root) && sumSoFar + root.val == targetSum) {
      sumPath.add(pathSoFar);
    } else {

      addSum(root.left, sumSoFar + root.val, getClone(pathSoFar), targetSum);
      addSum(root.right, sumSoFar + root.val, getClone(pathSoFar), targetSum);
    }
  }

  /**
   * @param list The list to copy.
   * @return A cloned list.
   */
  private static List<Integer> getClone(final List<Integer> list) {
    final List<Integer> clone = new ArrayList<>();

    list.forEach(
        element -> {
          clone.add(element);
        });

    return clone;
  }
}
