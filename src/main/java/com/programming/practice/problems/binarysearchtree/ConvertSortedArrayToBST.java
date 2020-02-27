package com.programming.practice.problems.binarysearchtree;

import com.programming.practice.datastructure.BinarySearchTree;
import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * <p>For this problem, a height-balanced binary tree is defined as a binary tree in which the depth
 * of the two subtrees of every node never differ by more than 1.
 *
 * @see <a href =
 *     "https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">Convert Sorted
 *     Array to Binary Search Tree</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ConvertSortedArrayToBST {

  private final BinarySearchTree tree = new BinarySearchTree();

  /** A list to store the order in which the insert should occur on binary search tree. */
  private final List<Integer> insertOrderList = new ArrayList<>();
  /**
   * Converts sorted array to Binary search tree which is height balanced.
   *
   * @param nums The sorted array.
   * @return The root of the constructed binary search tree.
   */
  public TreeNode sortedArrayToBST(final int[] nums) {
    addNodeToInsertOrderList(nums, 0, nums.length - 1);

    return tree.createBinaryTree(insertOrderList);
  }

  private void addNodeToInsertOrderList(
      final int[] nums, final int startIndex, final int endIndex) {

    if (startIndex > endIndex) {
      return;
    }

    final int mid = Math.floorDiv(startIndex + endIndex, 2);
    insertOrderList.add(nums[mid]);

    addNodeToInsertOrderList(nums, startIndex, mid - 1);
    addNodeToInsertOrderList(nums, mid + 1, endIndex);
  }
}
