package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BinaryTreeVerticalOrderTraversal}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class BinaryTreeVerticalOrderTraversalTest {

  private final BinaryTreeVerticalOrderTraversal obj = new BinaryTreeVerticalOrderTraversal();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testScenario1() {
    tree.createBinaryTree(Arrays.asList(3, 9, 20, null, null, 15, 7));

    final List<List<Integer>> expectedTraversal = new ArrayList<>();
    expectedTraversal.add(Arrays.asList(9));
    expectedTraversal.add(Arrays.asList(3, 15));
    expectedTraversal.add(Arrays.asList(20));
    expectedTraversal.add(Arrays.asList(7));

    Assert.assertEquals(expectedTraversal, obj.verticalOrder(tree.getRootNode()));
  }

  @Test
  public void testScenario2() {
    tree.createBinaryTree(Arrays.asList(3, 9, 8, 4, 0, 1, 7));

    final List<List<Integer>> expectedTraversal = new ArrayList<>();
    expectedTraversal.add(Arrays.asList(4));
    expectedTraversal.add(Arrays.asList(9));
    expectedTraversal.add(Arrays.asList(3, 0, 1));
    expectedTraversal.add(Arrays.asList(8));
    expectedTraversal.add(Arrays.asList(7));

    Assert.assertEquals(expectedTraversal, obj.verticalOrder(tree.getRootNode()));
  }

  @Test
  public void testScenario3() {
    tree.createBinaryTree(Arrays.asList(3, 9, 8, 4, 0, 1, 7, null, null, null, 2, 5));

    final List<List<Integer>> expectedTraversal = new ArrayList<>();
    expectedTraversal.add(Arrays.asList(4));
    expectedTraversal.add(Arrays.asList(9, 5));
    expectedTraversal.add(Arrays.asList(3, 0, 1));
    expectedTraversal.add(Arrays.asList(8, 2));
    expectedTraversal.add(Arrays.asList(7));

    Assert.assertEquals(expectedTraversal, obj.verticalOrder(tree.getRootNode()));
  }
}
