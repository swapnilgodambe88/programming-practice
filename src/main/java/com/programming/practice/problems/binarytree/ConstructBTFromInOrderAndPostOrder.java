package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * <p>Note: You may assume that duplicates do not exist in the tree.
 *
 * @see <a href =
 *     "https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">Construct
 *     Binary Tree from Inorder and Postorder Traversal</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ConstructBTFromInOrderAndPostOrder {

  // NOTE: postorderList nodes will be removed inside addNode.
  private final Stack<Integer> postorderStack = new Stack<>();
  private final List<Integer> inorderList = new ArrayList<>();

  /**
   * Constructs binary tree from preorder and inorder traversal list.
   *
   * @param inorder The inorder traversal list.
   * @param postorder The postorder traversal list.
   * @return The root node of the constructed binary tree.
   */
  public TreeNode buildTree(final int[] inorder, final int[] postorder) {

    // Assumes the length of both the lists will be same
    for (int i = 0; i < inorder.length; ++i) {
      postorderStack.push(postorder[i]);
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

    final TreeNode node = new TreeNode(postorderStack.pop());

    // Since it's postorder, first add the right node then the left node
    node.right = addNode(inorderList.indexOf(node.val) + 1, endIndex);
    node.left = addNode(startIndex, inorderList.indexOf(node.val) - 1);

    return node;
  }
}
