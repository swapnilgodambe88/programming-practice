package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * @see <a href = "https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Flatten Binary
 *     Tree to Linked List</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class FlattenBinaryTree {

  /**
   * Stack used to keep list of root on sub binary tree than needs to be inserted to right of a
   * given node (used in method 1).
   */
  private final Stack<TreeNode> nodeStack = new Stack<>();

  /** List used for insertion (used in method2). */
  private final List<Integer> nodeList = new ArrayList<>();

  /**
   * Flattens the binary tree to linked list in place (method1)
   *
   * @param root The root of the binary tree.
   */
  public void flatten1(final TreeNode root) {

    if (root == null) {
      return;
    }

    if (root.left != null) {
      // Push the left on the stack and make the root.left = null
      nodeStack.push(root.left);
      root.left = null;
    }

    if (root.right == null && !nodeStack.isEmpty()) {
      root.right = nodeStack.pop();
    } else if (root.right != null) {
      nodeStack.push(root.right);
      root.right = null;
      root.right = nodeStack.pop();
    }

    flatten1(root.right);
  }

  /**
   * Flattens the binary tree to linked list in place (method2)
   *
   * @param root The root of the binary tree.
   */
  public void flatten2(final TreeNode root) {
    if (root == null) {
      return;
    }
    preOrderTraversal(root);
    root.left = null;

    TreeNode currNode = root;
    for (int i = 1; i < nodeList.size(); ++i) {
      currNode.right = new TreeNode(nodeList.get(i));
      currNode = currNode.right;
    }
  }

  /**
   * Postorder traversal. Instead of printing, it will push the node value in the list.
   *
   * @param root The root of the tree.
   */
  private void preOrderTraversal(final TreeNode root) {
    if (root != null) {
      nodeList.add(root.val);
      preOrderTraversal(root.left);
      preOrderTraversal(root.right);
    }
  }
}
