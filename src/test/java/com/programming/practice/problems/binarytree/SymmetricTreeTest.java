package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SymmetricTree}.
 *
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class SymmetricTreeTest {
  private final SymmetricTree obj = new SymmetricTree();

  @Test
  public void testNullTree() {
    final BinaryTree tree = new BinaryTree();

    Assert.assertTrue(obj.isSymmetric(tree.getRootNode()));
  }

  @Test
  public void testSingleNodeTree() {
    final BinaryTree tree = new BinaryTree();
    tree.addNodeToBinaryTree(10);

    Assert.assertTrue(obj.isSymmetric(tree.getRootNode()));
  }

  @Test
  public void testSymmetric1() {
    final BinaryTree tree = new BinaryTree();
    tree.createBinaryTree(Arrays.asList(1, 2, 2, 3, 4, 4, 3));

    Assert.assertTrue(obj.isSymmetric(tree.getRootNode()));
  }

  @Test
  public void testSymmetric2() {
    final BinaryTree tree = new BinaryTree();
    tree.createBinaryTree(Arrays.asList(1, 2, 2, 3, null, null, 3));

    Assert.assertTrue(obj.isSymmetric(tree.getRootNode()));
  }

  @Test
  public void testASymmetric1() {
    final BinaryTree tree = new BinaryTree();
    tree.createBinaryTree(Arrays.asList(1, 2, 2, null, 3, null, 3));

    Assert.assertFalse(obj.isSymmetric(tree.getRootNode()));
  }
}
