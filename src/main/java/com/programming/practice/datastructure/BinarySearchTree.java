package com.programming.practice.datastructure;

import com.programming.practice.problems.binarytree.util.TreeNode;

/**
 * A Binary search tree representation.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BinarySearchTree extends BinaryTree {

  /** {@inheritDoc} */
  @Override
  public void addNodeToTree(final Integer element) throws IllegalArgumentException {
    if (root == null && element == null) {
      throw new IllegalArgumentException("Null node provided as root for the binary tree");
    }

    if (root == null) {
      root = new TreeNode(element);
    } else {
      TreeNode currNode = root;
      while (currNode != null) {
        if (currNode.left != null && element < currNode.val) {
          currNode = currNode.left;
        } else if (currNode.right != null && element >= currNode.val) {
          currNode = currNode.right;
        } else {
          break;
        }
      }

      final TreeNode nodeToInsert = new TreeNode(element);
      if (element < currNode.val) {
        currNode.left = nodeToInsert;
      } else {
        currNode.right = nodeToInsert;
      }
    }
  }
}
