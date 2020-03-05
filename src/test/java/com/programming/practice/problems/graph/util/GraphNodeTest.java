package com.programming.practice.problems.graph.util;

import java.util.Arrays;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link GraphNode}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class GraphNodeTest {

  @Test
  public void testHashCode() {
    final GraphNode node1 = new GraphNode(1);
    final GraphNode node2 = new GraphNode(2, Arrays.asList(node1));

    Assert.assertEquals(Objects.hash(node2.val, node2.neighbors), node2.hashCode());
  }

  @Test
  public void testConstructorWithNoParameters() {
    final GraphNode node1 = new GraphNode();

    Assert.assertEquals(0, node1.val);
    Assert.assertTrue(node1.neighbors.isEmpty());
  }

  @Test
  public void testConstructorWithOneParameters() {
    final GraphNode node1 = new GraphNode(99);

    Assert.assertEquals(99, node1.val);
    Assert.assertTrue(node1.neighbors.isEmpty());
  }

  @Test
  public void testConstructorWithTwoParameters() {
    final GraphNode node1 = new GraphNode(1);
    final GraphNode node2 = new GraphNode(2, Arrays.asList(node1));

    Assert.assertEquals(2, node2.val);
    Assert.assertEquals(Arrays.asList(node1), node2.neighbors);
  }

  @Test
  public void testToString() {
    final GraphNode node1 = new GraphNode(1);
    final GraphNode node2 = new GraphNode(2, Arrays.asList(node1));

    final String expectedToString = "Value: 2 | neighbors: 1 ";
    Assert.assertEquals(expectedToString, node2.toString());
  }

  @Test
  public void testEqualsObject() {
    final GraphNode node1 = new GraphNode(1);
    final GraphNode node2 = new GraphNode(1);

    Assert.assertTrue(node1.equals(node2));
  }

  @Test
  public void testNotEqualsObjectInVal() {
    final GraphNode node1 = new GraphNode(1);
    final GraphNode node2 = new GraphNode(2);

    Assert.assertFalse(node1.equals(node2));
  }

  @Test
  public void testNotEqualsObjectInNeighbors() {
    final GraphNode node1 = new GraphNode(1);
    final GraphNode node2 = new GraphNode(2, Arrays.asList(node1));

    final GraphNode node3 = new GraphNode(2);

    Assert.assertFalse(node3.equals(node2));
  }

  @SuppressWarnings("unlikely-arg-type")
  @Test
  public void testNotEqualsObjectInInstance() {
    final GraphNode node1 = new GraphNode(1);
    final Integer number = new Integer(19);

    Assert.assertFalse(node1.equals(number));
  }
}
