package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * <p>After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint
 * union of trees).
 *
 * <p>Return the roots of the trees in the remaining forest. You may return the result in any order.
 *
 * <pre>
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/delete-nodes-and-return-forest/">Delete Nodes And
 *     Return Forest</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company Google
 */
public final class DeleteNodesAndReturnForest {
  private final List<TreeNode> forest;

  /** Public constructor for {@link DeleteNodesAndReturnForest} */
  public DeleteNodesAndReturnForest() {
    this.forest = new ArrayList<>();
  }

  /**
   * Deletes the nodes with a value in to_delete, and returns the roots of the trees in the
   * remaining forest.
   *
   * @param root The root node of the binary tree.
   * @param to_delete The nodes to delete.
   * @return The roots of the trees in the remaining forest.
   */
  public List<TreeNode> delNodes(final TreeNode root, final int[] to_delete) {
    forest.add(root);

    for (final int nodeValueToDelete : to_delete) {
      deleteNode(nodeValueToDelete);
    }

    return forest;
  }

  /**
   * Deletes a single node from the forest. If the node to delete is one of the root nodes in the
   * forest, then it removes that node from the forest.
   *
   * @param nodeValueToDelete The node value to delete.
   */
  private void deleteNode(final int nodeValueToDelete) {

    for (final TreeNode forestNode : forest) {

      TreeNode nodeToDelete = null;
      if (forestNode.val == nodeValueToDelete) {
        nodeToDelete = forestNode;
      } else {
        final TreeNode parentOfSearchNode = parentOfSearchNode(forestNode, nodeValueToDelete);
        if (parentOfSearchNode != null) {
          if (parentOfSearchNode.left != null && parentOfSearchNode.left.val == nodeValueToDelete) {
            nodeToDelete = parentOfSearchNode.left;
            parentOfSearchNode.left = null;
          } else if (parentOfSearchNode.right != null
              && parentOfSearchNode.right.val == nodeValueToDelete) {
            nodeToDelete = parentOfSearchNode.right;
            parentOfSearchNode.right = null;
          }
        }
      }

      // Node to delete found in the existing iteration of the forest
      if (nodeToDelete != null) {

        if (nodeToDelete.left != null) {
          forest.add(nodeToDelete.left);
        }

        if (nodeToDelete.right != null) {
          forest.add(nodeToDelete.right);
        }

        if (forest.contains(nodeToDelete)) {
          forest.remove(nodeToDelete);
        }

        return;
      }
    }

    throw new RuntimeException("Node to delete not found on binary tree");
  }

  /**
   * Returns the parent node of the node to be searched. Returns null if node is not preset on the
   * tree.
   *
   * @param root The root node of the binary tree.
   * @param nodeValueToSearch The node value to search.
   * @return The parent node of the node to be searched. Returns null if node is not preset on the
   *     tree.
   */
  private static TreeNode parentOfSearchNode(final TreeNode root, final int nodeValueToSearch) {
    final Stack<TreeNode> stack = new Stack<>();
    stack.add(root);

    while (!stack.isEmpty()) {
      final TreeNode poppedNode = stack.pop();

      if ((poppedNode.left != null && poppedNode.left.val == nodeValueToSearch)
          || (poppedNode.right != null && poppedNode.right.val == nodeValueToSearch)) {
        return poppedNode;
      }

      if (poppedNode.left != null) {
        stack.push(poppedNode.left);
      }

      if (poppedNode.right != null) {
        stack.push(poppedNode.right);
      }
    }

    return null;
  }
}
