package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BoundaryOfBinaryTree}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BoundaryOfBinaryTreeTest {

  private final BinaryTree tree = new BinaryTree();
  private final BoundaryOfBinaryTree obj = new BoundaryOfBinaryTree();

  @Test
  public void testNullTree() {
    Assert.assertTrue(obj.boundaryOfBinaryTree(tree.getRootNode()).isEmpty());
  }

  @Test
  public void testSingleNodeTree() {
    final List<Integer> expectedBoundary = new LinkedList<>(Arrays.asList(8));

    tree.addNodeToTree(8);
    Assert.assertEquals(expectedBoundary, obj.boundaryOfBinaryTree(tree.getRootNode()));
  }

  @Test
  public void testLeftBoundaryTree() {
    final List<Integer> expectedBoundary = new LinkedList<>(Arrays.asList(1, 2, 3, 4));

    tree.createBinaryTree(Arrays.asList(1, 2, null, 3, null, null, null, 4));
    Assert.assertEquals(expectedBoundary, obj.boundaryOfBinaryTree(tree.getRootNode()));
  }

  @Test
  public void testRightBoundaryTree() {
    final List<Integer> expectedBoundary = new LinkedList<>(Arrays.asList(1, 3, 2));

    tree.createBinaryTree(Arrays.asList(1, null, 2, null, null, null, 3));
    Assert.assertEquals(expectedBoundary, obj.boundaryOfBinaryTree(tree.getRootNode()));
  }

  @Test
  public void testScenario1() {
    final List<Integer> expectedBoundary = new LinkedList<>(Arrays.asList(1, 4, 9, 8, 22, 3, 2));

    tree.createBinaryTree(Arrays.asList(1, 4, 2, 9, null, 3, null, null, 8, null, null, null, 22));
    Assert.assertEquals(expectedBoundary, obj.boundaryOfBinaryTree(tree.getRootNode()));
  }
}
