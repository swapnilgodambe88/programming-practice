package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array
 * has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * <pre>
 * Example:
 *
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/count-of-smaller-numbers-after-self/">Count of
 *     Smaller Numbers After Self</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company Google
 */
public final class CountOfSmallerNumbersAfterSelf {

  /** Represents a tree node on Binary search tree. */
  private class TreeNode {
    public int val;
    // Keeps track of the number of nodes on the left subtree of the node
    public int leftCount;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int val) {
      this.val = val;
      this.leftCount = 0;
      this.left = null;
      this.right = null;
    }
  }

  /** The root of the binary search tree. */
  private TreeNode root;

  /**
   * Counts the number of smaller elements to the right of the number.
   *
   * @param nums The nums array.
   * @return The counts array with count of smaller elements to the right of the self number.
   */
  public List<Integer> countSmaller(final int[] nums) {
    final List<Integer> smallCountInReverse = new ArrayList<>();

    for (int i = nums.length - 1; i >= 0; --i) {
      smallCountInReverse.add(insertNode(nums[i]));
    }

    Collections.reverse(smallCountInReverse);
    return smallCountInReverse;
  }

  /**
   * Inserts a node with the given value in the Binary search tree.
   *
   * @param val The value to insert.
   * @return The number of nodes with value smaller than the val.
   */
  private int insertNode(final int val) {
    // To keep track of the number of nodes in the binary search tree that are less than val.
    int smallCount = 0;
    if (root == null) {
      root = new TreeNode(val);
    } else {
      TreeNode curNode = root;

      while (curNode != null) {

        if (curNode.left != null && val < curNode.val) {
          // Since we are traversing to the left side of the tree, increment the left count of the
          // current node.
          ++curNode.leftCount;
          curNode = curNode.left;
        } else if (curNode.right != null && val >= curNode.val) {
          // Since we are traversing the right side of the currNode, all the left nodes of the
          // currNodes are less than the val. Therefore add the leftcount
          smallCount += curNode.leftCount;
          if (val > curNode.val) {
            // The if condition is introduced to not increment val for a duplicate node. e.g
            // inserting 5 in a BST which contains a 5
            ++smallCount;
          }
          curNode = curNode.right;
        } else {
          break;
        }
      }

      final TreeNode nodeToInsert = new TreeNode(val);
      if (val < curNode.val) {
        // Since we are inserting to the left of the currNode, increment the leftCount.
        ++curNode.leftCount;
        curNode.left = nodeToInsert;
      } else {
        smallCount += curNode.leftCount;
        if (val > curNode.val) {
          ++smallCount;
        }
        curNode.right = nodeToInsert;
      }
    }

    return smallCount;
  }
}
