package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * <p>Note: You may assume that duplicates do not exist in the tree.
 *
 * @see <a href =
 *     "https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Construct
 *     Binary Tree from Preorder and Inorder Traversal</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ConstructBTFromInOrderAndPreOrder {

  // NOTE: preorderList nodes will be removed inside addNode.
  private final Queue<Integer> preorderList = new LinkedList<>();
  private final List<Integer> inorderList = new ArrayList<>();

  /**
   * Constructs binary tree from preorder and inorder traversal list.
   *
   * @param preorder The preorder traversal list.
   * @param inorder The inorder traversal list.
   * @return The root node of the constructed binary tree.
   */
  public TreeNode buildTree(final int[] preorder, final int[] inorder) {

    // Assumes the length of both the lists will be same
    for (int i = 0; i < preorder.length; ++i) {
      preorderList.add(preorder[i]);
      inorderList.add(inorder[i]);
    }

    return addNode(0, inorder.length - 1);
  }

  /**
   * Recursive function to add nodes.
   *
   * @param startIndex The start index in inorder list.
   * @param endIndex The endIndex in inorder list.
   * @return The root node of the tree
   */
  private TreeNode addNode(final int startIndex, final int endIndex) {
    if (startIndex > endIndex) {
      return null;
    }

    final TreeNode node = new TreeNode(preorderList.remove());

    // Since it's preorder, first add the left node then the right node
    node.left = addNode(startIndex, inorderList.indexOf(node.val) - 1);
    node.right = addNode(inorderList.indexOf(node.val) + 1, endIndex);

    return node;
  }
}
