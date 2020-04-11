package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so
 * that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 *
 * <p>Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how
 * your serialization/deserialization algorithm should work. You just need to ensure that a binary
 * tree can be serialized to a string and this string can be deserialized to the original tree
 * structure.
 *
 * <p><b>NOTE:</b> This solution works for binary search tree as well.
 *
 * @see <a href = "https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">Serialize
 *     and Deserialize Binary Tree</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class SerializeAndDeserializeBinaryTree {

  private static final String PARENT_CHILDREN_SEPERATOR = "#";
  private static final String SIBLING_SEPERATOR = "$";
  private static final String NODE_SEPARATOR = "|";

  /**
   * Serializes a binary tree.
   *
   * @param root The root node of the binary tree.
   * @return The serialized binary tree.
   */
  public String serialize(final TreeNode root) {

    if (root == null) {
      return "";
    }

    final List<TreeNode> bfsNodeList = new LinkedList<>();
    final Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);
    while (!queue.isEmpty()) {
      final TreeNode poppedNode = queue.remove();
      bfsNodeList.add(poppedNode);

      if (poppedNode.left != null) {
        queue.add(poppedNode.left);
      }

      if (poppedNode.right != null) {
        queue.add(poppedNode.right);
      }
    }

    final String serializedString = convertBfsNodeListToString(bfsNodeList);
    return serializedString;
  }

  /**
   * Deserializes binary tree.
   *
   * @param data The serialized binary tree.
   * @return The root node after deserialization.
   */
  public TreeNode deserialize(final String data) {
    if (data.isEmpty()) {
      return null;
    }
    final List<TreeNode> bfsNodeList = convertSerializedStringToBfsNodeList(data);

    return bfsNodeList.get(0);
  }

  /**
   * Converts list of bfs nodes to serialized string.
   *
   * @param bfsNodeList The list of TreeNode.
   * @return The serialized string,
   */
  private String convertBfsNodeListToString(final List<TreeNode> bfsNodeList) {
    final StringBuffer serializedString = new StringBuffer();

    for (final TreeNode treeNode : bfsNodeList) {
      serializedString.append(treeNode.val);
      serializedString.append(PARENT_CHILDREN_SEPERATOR);

      if (treeNode.left != null) {
        serializedString.append(treeNode.left.val);
      } else {
        serializedString.append("null");
      }

      serializedString.append(SIBLING_SEPERATOR);

      if (treeNode.right != null) {
        serializedString.append(treeNode.right.val);
      } else {
        serializedString.append("null");
      }

      serializedString.append(NODE_SEPARATOR);
    }

    return serializedString.toString();
  }

  /**
   * Converts a serializedString to a list of TreeNode.
   *
   * @param serializedString The serialized binary tree.
   * @return A list of TreeNode.
   */
  private List<TreeNode> convertSerializedStringToBfsNodeList(final String serializedString) {
    if (serializedString.isEmpty()) {
      return null;
    }

    final String[] serializedNodeList = serializedString.split("\\" + NODE_SEPARATOR);

    final List<TreeNode> bfsNodeList = new LinkedList<>();
    final Queue<TreeNode> queue = new LinkedList<>();

    final TreeNode firstNode =
        new TreeNode(
            Integer.valueOf(serializedNodeList[0].split("\\" + PARENT_CHILDREN_SEPERATOR)[0]));

    queue.add(firstNode);

    for (final String serializedNode : serializedNodeList) {
      final TreeNode poppedNode = queue.remove();

      final String[] serializedNodeChildren =
          serializedNode.split("\\" + PARENT_CHILDREN_SEPERATOR)[1].split("\\" + SIBLING_SEPERATOR);

      if (!serializedNodeChildren[0].equals("null")) {
        final TreeNode leftChild = new TreeNode(Integer.valueOf(serializedNodeChildren[0]));

        poppedNode.left = leftChild;
        queue.add(leftChild);
      }

      if (!serializedNodeChildren[1].equals("null")) {
        final TreeNode rightChild = new TreeNode(Integer.valueOf(serializedNodeChildren[1]));

        poppedNode.right = rightChild;
        queue.add(rightChild);
      }

      bfsNodeList.add(poppedNode);
    }

    return bfsNodeList;
  }
}
