package com.programming.practice.datastructure;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Stack;

/**
 * A binary tree representation.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BinaryTree {

  /** The root node of the binary tree. */
  private TreeNode root = null;

  /** The list of node present on the binary tree. */
  private List<TreeNode> nodes = new LinkedList<>();

  /** @return The root node of the binary tree. */
  public final TreeNode getRootNode() {
    return this.root;
  }

  /**
   * Creates a binary tree and returns the root node.<br>
   * NOTE: Any previously added nodes to the binary tree will be erased.
   *
   * @param elements The array of elements on the binary tree.
   * @return The root node of the constructed binary tree.
   */
  public final TreeNode createBinaryTree(final List<Integer> elements) {

    this.root = null;
    this.nodes.clear();

    for (final Integer element : elements) {
      addNodeToBinaryTree(element);
    }

    return root;
  }

  /** In-order traversal of the binary tree. */
  public final void inOrderTraversal() {
    System.out.println("Inorder Traversal: ");
    BinaryTree.inOrderRecursion(root);
  }

  /**
   * In-order traversal of a binary tree in recursion.
   *
   * @param node The node of the binary tree.
   */
  private static final void inOrderRecursion(final TreeNode node) {
    if (node != null) {
      inOrderRecursion(node.left);
      System.out.println(node.val);
      inOrderRecursion(node.right);
    }
  }

  /**
   * Adds an element to the binary tree.
   *
   * @param element The element to insert.
   * @throws IllegalArgumentException If element provided is null for the root of the binary tree.
   */
  public final void addNodeToBinaryTree(final Integer element) throws IllegalArgumentException {

    if (root == null && element == null) {
      throw new IllegalArgumentException("Null node provided as root for the binary tree");
    }

    if (root == null && element != null) {
      root = new TreeNode(element);
      nodes.add(root);
    } else if (element == null) {
      nodes.add(null);
    } else {
      final TreeNode nodeToInsert = new TreeNode(element);

      final int indexPositionToInsert = nodes.size();
      final int parentIndex = Math.floorDiv(indexPositionToInsert - 1, 2);

      final TreeNode parentNode = nodes.get(parentIndex);
      if (indexPositionToInsert % 2 == 0) {
        parentNode.right = nodeToInsert;
      } else {
        parentNode.left = nodeToInsert;
      }

      nodes.add(nodeToInsert);
    }
  }

  /**
   * Performs a Breadth First Search (BFS) for the value on the tree.
   *
   * @param valueToSearch The value to search.
   * @return An {@link TreeNode} wrapped in {@link Optional} for the valueToSearch. Returns {@link
   *     Optional#empty()} if value is not found.
   */
  public final Optional<TreeNode> BFSSearch(final int valueToSearch) {
    final Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) {
      return Optional.empty();
    }

    queue.add(root);
    while (!queue.isEmpty()) {

      final TreeNode poppedNode = queue.remove();

      if (poppedNode.val == valueToSearch) {
        return Optional.of(poppedNode);
      }

      if (poppedNode.left != null) {
        queue.add(poppedNode.left);
      }

      if (poppedNode.right != null) {
        queue.add(poppedNode.right);
      }
    }

    return Optional.empty();
  }

  /**
   * Performs a Depth First Search (DFS) for the value on the tree.
   *
   * @param valueToSearch The value to search.
   * @return An {@link TreeNode} wrapped in {@link Optional} for the valueToSearch. Returns {@link
   *     Optional#empty()} if value is not found.
   */
  public final Optional<TreeNode> DFSSearch(final int valueToSearch) {
    final Stack<TreeNode> stack = new Stack<>();
    if (root == null) {
      return Optional.empty();
    }

    stack.add(root);
    while (!stack.isEmpty()) {

      final TreeNode poppedNode = stack.pop();

      if (poppedNode.val == valueToSearch) {
        return Optional.of(poppedNode);
      }

      if (poppedNode.left != null) {
        stack.add(poppedNode.left);
      }

      if (poppedNode.right != null) {
        stack.add(poppedNode.right);
      }
    }

    return Optional.empty();
  }
}
