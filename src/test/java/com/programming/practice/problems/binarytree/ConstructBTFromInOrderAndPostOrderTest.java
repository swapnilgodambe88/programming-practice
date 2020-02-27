package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.test.util.BinaryTreeTestUtil;
import com.programming.practice.problems.binarytree.util.TreeNode;
import org.junit.Test;

/**
 * White box tests for {@link ConstructBTFromInOrderAndPostOrder}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ConstructBTFromInOrderAndPostOrderTest {

  private final ConstructBTFromInOrderAndPostOrder obj = new ConstructBTFromInOrderAndPostOrder();

  @Test
  public void testScenario1() {
    final int[] preorder = new int[] {9, 3, 15, 20, 7};
    final int[] postorder = new int[] {9, 15, 7, 20, 3};

    final TreeNode root = obj.buildTree(preorder, postorder);

    BinaryTreeTestUtil.assertNode(3, 9, 20, root);
    BinaryTreeTestUtil.assertNode(9, null, null, root.left);
    BinaryTreeTestUtil.assertNode(20, 15, 7, root.right);
    BinaryTreeTestUtil.assertNode(15, null, null, root.right.left);
    BinaryTreeTestUtil.assertNode(7, null, null, root.right.right);
  }
}
