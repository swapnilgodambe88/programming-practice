package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BinaryTreeInOrderTraversal}.
 *
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class BinaryTreeInOrderTraversalTest {

  private final BinaryTreeInOrderTraversal obj = new BinaryTreeInOrderTraversal();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testEmptyTree() {
    final List<Integer> expectedTraversal = new ArrayList<>();

    Assert.assertEquals(expectedTraversal, obj.inorderTraversal(tree.getRootNode()));
  }

  @Test
  public void testScenario1() {
    tree.createBinaryTree(Arrays.asList(1, null, 2, null, null, 3));
    final List<Integer> expectedTraversal = Arrays.asList(1, 3, 2);

    Assert.assertEquals(expectedTraversal, obj.inorderTraversal(tree.getRootNode()));
  }

  @Test
  public void testScenario2() {
    tree.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    final List<Integer> expectedTraversal = Arrays.asList(8, 4, 9, 2, 5, 1, 6, 3, 7);

    Assert.assertEquals(expectedTraversal, obj.inorderTraversal(tree.getRootNode()));
  }
}
