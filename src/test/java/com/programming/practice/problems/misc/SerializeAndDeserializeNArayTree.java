package com.programming.practice.problems.misc;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so
 * that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 *
 * <p>Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree
 * in which each node has no more than N children. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree
 * can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * @see <a href = "https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/">Serialize
 *     and Deserialize N-ary Tree</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SerializeAndDeserializeNArayTree {

  /**
   * Node representation of N-aray tree.
   *
   * @see <a href = ""></a>
   * @author Swapnil Godambe.<br>
   *     Copyright 2020.
   */
  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(final int _val) {
      val = _val;
    }

    public Node(final int _val, final List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  private static final String PARENT_CHILDREN_SEPERATOR = "#";
  private static final String SIBLING_SEPERATOR = "$";
  private static final String NODE_SEPARATOR = "|";

  /**
   * Serializes the tree to string.
   *
   * @param root The root of the N-ary tree.
   * @return
   */
  public String serialize(final Node root) {
    if (root == null) {
      return "";
    }

    // final Map<Integer, List<Integer>> treeMap = new LinkedHashMap<>();
    final List<Node> bfsNodeList = new LinkedList<>();
    final Queue<Node> queue = new LinkedList<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      final Node poppedNode = queue.remove();

      bfsNodeList.add(poppedNode);

      for (final Node child : poppedNode.children) {
        queue.add(child);
      }
    }

    final String serializedString = convertBfsNodeListToString(bfsNodeList);
    return serializedString;
  }

  // Decodes your encoded data to tree.
  public Node deserialize(final String data) {
    if (data.equals("")) {
      return null;
    }

    final List<Node> bsfNodeList = convertStringToBfsNodeList(data);

    return bsfNodeList.get(0);
  }

  private static String convertBfsNodeListToString(final List<Node> bfsList) {
    final StringBuffer serializedString = new StringBuffer();

    for (final Node node : bfsList) {
      serializedString.append(node.val);
      serializedString.append(PARENT_CHILDREN_SEPERATOR);

      for (final Node child : node.children) {
        serializedString.append(child.val);
        serializedString.append(SIBLING_SEPERATOR);
      }

      serializedString.append(NODE_SEPARATOR);
    }

    return serializedString.toString();
  }

  private List<Node> convertStringToBfsNodeList(final String string) {
    final String[] nodes = string.split("\\" + NODE_SEPARATOR);

    final List<Node> bfsNodeList = new LinkedList<>();
    final Queue<Node> queue = new LinkedList<>();
    final Node firstNode =
        new Node(Integer.valueOf(nodes[0].split(PARENT_CHILDREN_SEPERATOR)[0]), new LinkedList<>());
    queue.add(firstNode);

    for (final String node : nodes) {
      final String[] mapEntrySplit = node.split("\\" + PARENT_CHILDREN_SEPERATOR);
      final Node poppedNode = queue.remove();

      // Included condition to for nodes without any children
      if (mapEntrySplit.length > 1) {
        for (final String child : mapEntrySplit[1].split("\\" + SIBLING_SEPERATOR)) {
          final Node childNode = new Node(Integer.valueOf(child), new LinkedList<>());
          poppedNode.children.add(childNode);
          queue.add(childNode);
        }
      }

      bfsNodeList.add(poppedNode);
    }

    return bfsNodeList;
  }
}
