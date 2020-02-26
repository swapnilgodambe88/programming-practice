package com.programming.practice.datastructure;

import com.programming.practice.problems.binarytree.test.util.BinaryTreeTestUtil;
import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * White box tests for {@link BinaryTree}
 *
 * <p>Copyright 2020.<br>
 *
 * @author Swapnil Godambe.
 */
public final class BinaryTreeTest {

  @Rule public final ExpectedException exceptionRule = ExpectedException.none();

  private final BinaryTree obj = new BinaryTree();

  @Test
  public void testCreateBinaryTree() {
    final TreeNode rootNode = obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    BinaryTreeTestUtil.assertNode(1, 2, 3, rootNode);
  }

  @Test
  public void testCreateBinaryTreeThrowsExceptionForNullNode() {
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("Null node provided as root for the binary tree");

    final List<Integer> nodes = new ArrayList<>();
    nodes.add(null);
    obj.createBinaryTree(nodes);
  }

  @Test
  public void testBFSSearch() {
    obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    BinaryTreeTestUtil.assertOptionalNode(1, 2, 3, obj.BFSSearch(1));
    BinaryTreeTestUtil.assertOptionalNode(2, 4, 5, obj.BFSSearch(2));
    BinaryTreeTestUtil.assertOptionalNode(3, 6, 7, obj.BFSSearch(3));
    BinaryTreeTestUtil.assertOptionalNode(4, 8, 9, obj.BFSSearch(4));
    BinaryTreeTestUtil.assertOptionalNode(5, 10, null, obj.BFSSearch(5));
    BinaryTreeTestUtil.assertOptionalNode(6, null, null, obj.BFSSearch(6));
    BinaryTreeTestUtil.assertOptionalNode(7, null, null, obj.BFSSearch(7));
    BinaryTreeTestUtil.assertOptionalNode(8, null, null, obj.BFSSearch(8));
    BinaryTreeTestUtil.assertOptionalNode(9, null, null, obj.BFSSearch(9));
    BinaryTreeTestUtil.assertOptionalNode(10, null, null, obj.BFSSearch(10));
  }

  @Test
  public void testBFSSearchWithSomeNodesNull() {
    obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, null, 6, 7, null, 9));

    BinaryTreeTestUtil.assertOptionalNode(1, 2, 3, obj.BFSSearch(1));
    BinaryTreeTestUtil.assertOptionalNode(2, 4, null, obj.BFSSearch(2));
    BinaryTreeTestUtil.assertOptionalNode(3, 6, 7, obj.BFSSearch(3));
    BinaryTreeTestUtil.assertOptionalNode(4, null, 9, obj.BFSSearch(4));
    BinaryTreeTestUtil.assertOptionalNode(6, null, null, obj.BFSSearch(6));
    BinaryTreeTestUtil.assertOptionalNode(7, null, null, obj.BFSSearch(7));
    BinaryTreeTestUtil.assertOptionalNode(9, null, null, obj.BFSSearch(9));
  }

  @Test
  public void testDFSSearch() {
    obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    BinaryTreeTestUtil.assertOptionalNode(1, 2, 3, obj.DFSSearch(1));
    BinaryTreeTestUtil.assertOptionalNode(2, 4, 5, obj.DFSSearch(2));
    BinaryTreeTestUtil.assertOptionalNode(3, 6, 7, obj.DFSSearch(3));
    BinaryTreeTestUtil.assertOptionalNode(4, 8, 9, obj.DFSSearch(4));
    BinaryTreeTestUtil.assertOptionalNode(5, 10, null, obj.DFSSearch(5));
    BinaryTreeTestUtil.assertOptionalNode(6, null, null, obj.DFSSearch(6));
    BinaryTreeTestUtil.assertOptionalNode(7, null, null, obj.DFSSearch(7));
    BinaryTreeTestUtil.assertOptionalNode(8, null, null, obj.DFSSearch(8));
    BinaryTreeTestUtil.assertOptionalNode(9, null, null, obj.DFSSearch(9));
    BinaryTreeTestUtil.assertOptionalNode(10, null, null, obj.DFSSearch(10));
  }

  @Test
  public void testDFSSearchWithSomeNodesNull() {
    obj.createBinaryTree(Arrays.asList(1, 2, 3, 4, null, 6, 7, null, 9));

    BinaryTreeTestUtil.assertOptionalNode(1, 2, 3, obj.DFSSearch(1));
    BinaryTreeTestUtil.assertOptionalNode(2, 4, null, obj.DFSSearch(2));
    BinaryTreeTestUtil.assertOptionalNode(3, 6, 7, obj.DFSSearch(3));
    BinaryTreeTestUtil.assertOptionalNode(4, null, 9, obj.DFSSearch(4));
    BinaryTreeTestUtil.assertOptionalNode(6, null, null, obj.DFSSearch(6));
    BinaryTreeTestUtil.assertOptionalNode(7, null, null, obj.DFSSearch(7));
    BinaryTreeTestUtil.assertOptionalNode(9, null, null, obj.DFSSearch(9));
  }
}
