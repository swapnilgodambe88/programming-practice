package com.programming.practice.problems.misc;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

  private static final String DASH = "-";
  private static final String DOLLAR = "$";
  private static final String SEPARATOR = "|";

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

    final Map<Integer, List<Integer>> treeMap = new LinkedHashMap<>();
    final Queue<Node> queue = new LinkedList<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      final Node poppedNode = queue.remove();

      treeMap.put(poppedNode.val, convertListOfNodesToListOfIntegers(poppedNode.children));

      for (final Node child : poppedNode.children) {
        queue.add(child);
      }
    }

    System.out.println("treeMap: " + treeMap);

    final String serializedString = convertMapToString(treeMap);
    System.out.println("serializedString: " + serializedString);
    return serializedString;
  }

  // Decodes your encoded data to tree.
  public Node deserialize(final String data) {
    if (data.equals("")) {
      return null;
    }

    final Map<Integer, List<Integer>> deserializedMap = convertStringToMap(data);
    final Map<Integer, Node> treeMapping = new LinkedHashMap<>();

    for (final int nodeValue : deserializedMap.keySet()) {
      treeMapping.put(nodeValue, new Node(nodeValue, new LinkedList<>()));
    }

    for (final Map.Entry<Integer, List<Integer>> mapEntry : deserializedMap.entrySet()) {
      final int nodeValue = mapEntry.getKey();

      final Node parentNode = treeMapping.get(nodeValue);

      final List<Node> childrenNodes = new LinkedList<>();
      for (final int child : mapEntry.getValue()) {
        childrenNodes.add(treeMapping.get(child));
      }

      if (childrenNodes.size() > 0) {
        parentNode.children = childrenNodes;
      }
    }

    return treeMapping.values().iterator().next();
  }

  private static List<Integer> convertListOfNodesToListOfIntegers(final List<Node> nodeList) {
    final List<Integer> list = new LinkedList<>();

    for (final Node node : nodeList) {
      list.add(node.val);
    }

    return list;
  }

  private static String convertMapToString(final Map<Integer, List<Integer>> map) {
    final StringBuffer serializedString = new StringBuffer();

    for (final Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      serializedString.append(entry.getKey());
      serializedString.append(DASH);

      for (final int child : entry.getValue()) {
        serializedString.append(child);
        serializedString.append(DOLLAR);
      }

      serializedString.append(SEPARATOR);
    }

    return serializedString.toString();
  }

  private static Map<Integer, List<Integer>> convertStringToMap(final String string) {
    final String[] mapEntries = string.split("\\" + SEPARATOR);

    final Map<Integer, List<Integer>> map = new LinkedHashMap<>();
    for (final String mapEntry : mapEntries) {
      final String[] mapEntrySplit = mapEntry.split("\\" + DASH);

      final int key = Integer.valueOf(mapEntrySplit[0]);

      final List<Integer> children = new LinkedList<>();

      // Included condition to for nodes without any children
      if (mapEntrySplit.length > 1) {
        for (final String child : mapEntrySplit[1].split("\\" + DOLLAR)) {
          children.add(Integer.valueOf(child));
        }
      }

      map.put(key, children);
    }

    return map;
  }
}
