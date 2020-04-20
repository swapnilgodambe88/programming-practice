package com.programming.practice.datastructure;

import java.util.Objects;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link TrieNode}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class TrieNodeTest {

  @Test
  public void testConstructor() {
    final TrieNode node = new TrieNode('a');

    Assert.assertEquals('a', node.character);
    Assert.assertNotNull(node.children);

    for (final TrieNode child : node.children) {
      Assert.assertNull(child);
    }
  }

  @Test
  public void testHash() {
    final TrieNode node = new TrieNode('a');

    Assert.assertEquals(
        Objects.hash(node.character, node.children, node.endOfWord), node.hashCode());
  }

  @Test
  public void testEqualsSameObject() {
    final TrieNode node = new TrieNode('a');

    Assert.assertTrue(node.equals(node));
  }

  @SuppressWarnings("unlikely-arg-type")
  @Test
  public void testEqualsDifferentInstance() {
    final TrieNode node = new TrieNode('a');
    final String node2 = "node2";

    Assert.assertFalse(node.equals(node2));
  }

  @Test
  public void testEquals() {
    final TrieNode node1 = new TrieNode('a');
    final TrieNode node2 = new TrieNode('a');

    Assert.assertTrue(node1.equals(node2));
  }

  @Test
  public void testEqualsDifferentCharacter() {
    final TrieNode node1 = new TrieNode('a');
    final TrieNode node2 = new TrieNode('b');

    Assert.assertFalse(node1.equals(node2));
  }

  @Test
  public void testEqualsDifferentEndOfWord() {
    final TrieNode node1 = new TrieNode('a');
    final TrieNode node2 = new TrieNode('a');
    node2.endOfWord = true;

    Assert.assertFalse(node1.equals(node2));
  }

  @Test
  public void testEqualsDifferentChildren() {
    final TrieNode node1 = new TrieNode('a');
    final TrieNode node2 = new TrieNode('a');

    node1.children[0] = new TrieNode('x');

    Assert.assertFalse(node1.equals(node2));
  }
}
