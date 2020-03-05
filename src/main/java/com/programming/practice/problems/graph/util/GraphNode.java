package com.programming.practice.problems.graph.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Graph node.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class GraphNode {

  /** The value of the node. */
  public final int val;

  /** A list representing the neighbors of the node. */
  public List<GraphNode> neighbors;

  /** Constructor for {@link GraphNode}. */
  public GraphNode() {
    val = 0;
    neighbors = new ArrayList<>();
  }

  /**
   * Constructor for {@link GraphNode}.
   *
   * @param val The value of the node.
   */
  public GraphNode(final int val) {
    this.val = val;
    neighbors = new ArrayList<>();
  }

  /**
   * Constructor for {@link GraphNode}.
   *
   * @param val The value of the node.
   * @param neighbors A list representing the neighbors of the node.
   */
  public GraphNode(final int val, final List<GraphNode> neighbors) {
    this.val = val;
    this.neighbors = neighbors;
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode() {
    return Objects.hash(val, neighbors);
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    final StringBuffer printString = new StringBuffer();

    printString.append("Value: ").append(val).append(" | neighbors: ");
    neighbors.forEach(
        neighbor -> {
          printString.append(neighbor.val).append(" ");
        });

    return printString.toString();
  }

  /** {@inheritDoc} */
  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof GraphNode)) {
      return false;
    }

    final GraphNode other = (GraphNode) object;
    if (val != other.val) {
      return false;
    }

    if (!Objects.equals(this.neighbors, other.neighbors)) {
      return false;
    }

    return true;
  }
}
