package com.programming.practice.problems.binarytree;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import com.programming.practice.datastructure.BinaryTree;

/**
 * White box tests for {@link SameTree}.
 *
 * @author Swapnil Godambe.<br>
 *         Copyright 2020.
 */
public final class SameTreeTest {

  private final SameTree obj = new SameTree();
  private final BinaryTree tree1 = new BinaryTree();
  private final BinaryTree tree2 = new BinaryTree();

  @Test
  public void testEmptyTreeAreSame() {
    Assert.assertTrue(obj.isSameTree(tree1.getRootNode(), tree2.getRootNode()));
  }

  @Test
  public void testNotSameTree() {
    tree1.createBinaryTree(Arrays.asList(1, 2, 3, null, 4));
    tree2.createBinaryTree(Arrays.asList(1, 2, 3, null, 4, null, 5));

    Assert.assertFalse(obj.isSameTree(tree1.getRootNode(), tree2.getRootNode()));
  }

  @Test
  public void testSameTree() {
    tree1.createBinaryTree(Arrays.asList(1, 2, 3, null, 4, null, 5));
    tree2.createBinaryTree(Arrays.asList(1, 2, 3, null, 4, null, 5));

    Assert.assertTrue(obj.isSameTree(tree1.getRootNode(), tree2.getRootNode()));
  }
}
