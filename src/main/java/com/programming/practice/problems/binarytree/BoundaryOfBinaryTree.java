package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from
 * root. Boundary includes left boundary, leaves, and right boundary in order without duplicate
 * nodes. (The values of the nodes may still be duplicates.)
 *
 * <p>Left boundary is defined as the path from root to the left-most node. Right boundary is
 * defined as the path from root to the right-most node. If the root doesn't have left subtree or
 * right subtree, then the root itself is left boundary or right boundary. Note this definition only
 * applies to the input binary tree, and not applies to any subtrees.
 *
 * <p>The left-most node is defined as a leaf node you could reach when you always firstly travel to
 * the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf
 * node.
 *
 * <p>The right-most node is also defined by the same way with left and right exchanged.
 *
 * @see <a href = "https://leetcode.com/problems/boundary-of-binary-tree/">Boundary of Binary
 *     Tree</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class BoundaryOfBinaryTree {

  /**
   * @param root The root of the Binary Tree.
   * @return The boundary of the binary tree.
   */
  public List<Integer> boundaryOfBinaryTree(final TreeNode root) {

    final List<Integer> boundary = new LinkedList<>();

    if (root != null) {
      boundary.add(root.val);
      boundary.addAll(getNonLeafLeftBoundayNodesTopToBottom(root.left));

      // condition added to prevent root node getting added twice if the tree can single node
      if (!TreeNode.isLeafNode(root)) {
        boundary.addAll(getLeafNodesRightToLeft(root));
      }

      boundary.addAll(getNonLeafRightBoundayNodesBottomToTop(root.right));
    }

    return boundary;
  }

  /**
   * @note The root node provided is included in the list.
   * @param root The root of the tree.
   * @return The left boundary nodes starting with root from top to bottom.
   */
  private List<Integer> getNonLeafLeftBoundayNodesTopToBottom(final TreeNode root) {
    TreeNode currNode = root;

    final List<Integer> leftBoundaryNodes = new LinkedList<>();
    while (currNode != null && !TreeNode.isLeafNode(currNode)) {
      leftBoundaryNodes.add(currNode.val);

      if (currNode.left != null) {
        currNode = currNode.left;
      } else {
        currNode = currNode.right;
      }
    }

    return leftBoundaryNodes;
  }

  /**
   * @note The root node provided is included in the list.
   * @param root The root of the tree.
   * @return The right boundary nodes starting with root from bottom to top.
   */
  private List<Integer> getNonLeafRightBoundayNodesBottomToTop(final TreeNode root) {
    TreeNode currNode = root;

    final List<Integer> rightBoundaryNodes = new LinkedList<>();
    while (currNode != null && !TreeNode.isLeafNode(currNode)) {
      rightBoundaryNodes.add(currNode.val);

      if (currNode.right != null) {
        currNode = currNode.right;
      } else {
        currNode = currNode.left;
      }
    }

    Collections.reverse(rightBoundaryNodes);
    return rightBoundaryNodes;
  }

  /**
   * @note The root node provided is included in the list, if it is a leaf node.
   * @param root The root of the tree (cannot be null).
   * @return The leaf nodes from left to right.
   */
  private List<Integer> getLeafNodesRightToLeft(final TreeNode root) {

    assert root != null;

    final Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    final List<Integer> leafNodes = new LinkedList<>();

    // NOTE: Since stack is LIFO we first push right then left to achieve the safe effect of inorder
    // traversal
    while (!stack.isEmpty()) {

      final TreeNode currNode = stack.pop();

      if (currNode.right != null) {
        stack.push(currNode.right);
      }

      if (TreeNode.isLeafNode(currNode)) {
        leafNodes.add(currNode.val);
      }

      if (currNode.left != null) {
        stack.add(currNode.left);
      }
    }

    return leafNodes;
  }
}
