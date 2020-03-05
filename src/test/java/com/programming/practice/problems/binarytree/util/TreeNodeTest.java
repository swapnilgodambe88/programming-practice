package com.programming.practice.problems.binarytree.util;

import com.programming.practice.problems.binarytree.test.util.BinaryTreeTestUtil;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link TreeNode}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class TreeNodeTest {

  @Test
  public void testHashCode() {
    final TreeNode node = new TreeNode(18);

    Assert.assertEquals(Objects.hash(node.val, node.left, node.right), node.hashCode());
  }

  @Test
  public void testTreeNode() {
    final TreeNode node = new TreeNode(18);

    Assert.assertEquals(18, node.val);
    Assert.assertNull(node.left);
    Assert.assertNull(node.right);
  }

  @Test
  public void testToString() {
    final TreeNode node = new TreeNode(18);

    BinaryTreeTestUtil.assertNode(18, null, null, node);
  }

  @Test
  public void testEqualsObject() {
    final TreeNode node1 = new TreeNode(18);
    final TreeNode node2 = new TreeNode(18);

    Assert.assertTrue(node1.equals(node2));
  }

  @Test
  public void testSameObject() {
    final TreeNode node1 = new TreeNode(18);

    Assert.assertTrue(node1.equals(node1));
  }

  @Test
  public void testNotEqualsObjectInVal() {
    final TreeNode node1 = new TreeNode(18);
    final TreeNode node2 = new TreeNode(19);

    Assert.assertFalse(node1.equals(node2));
  }

  @Test
  public void testNotEqualsObjectInRight() {
    final TreeNode node1 = new TreeNode(18);
    final TreeNode node2 = new TreeNode(18);
    node2.right = new TreeNode(99);

    Assert.assertFalse(node1.equals(node2));
  }

  @Test
  public void testNotEqualsObjectInLeft() {
    final TreeNode node1 = new TreeNode(18);
    final TreeNode node2 = new TreeNode(18);
    node2.left = new TreeNode(99);

    Assert.assertFalse(node1.equals(node2));
  }

  @SuppressWarnings("unlikely-arg-type")
  @Test
  public void testNotEqualsObjectInInstance() {
    final TreeNode node1 = new TreeNode(18);
    final Integer number = new Integer(19);

    Assert.assertFalse(node1.equals(number));
  }

  @Test
  public void testIsLeafNode() {
    final TreeNode node = new TreeNode(18);

    Assert.assertTrue(TreeNode.isLeafNode(node));
  }
}
