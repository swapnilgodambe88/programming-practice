package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BinaryTreeLevelOrderTraversal}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BinaryTreeLevelOrderTraversalTest {

  private final BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testEmptyBinaryTree() {
    final List<List<Integer>> expectedList = new ArrayList<>();

    Assert.assertEquals(expectedList, obj.levelOrder(tree.getRootNode()));
  }

  @Test
  public void testValidBinaryTree1() {
    tree.createBinaryTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
    final List<List<Integer>> expectedList = new ArrayList<>();
    expectedList.add(Arrays.asList(3));
    expectedList.add(Arrays.asList(9, 20));
    expectedList.add(Arrays.asList(15, 7));

    Assert.assertEquals(expectedList, obj.levelOrder(tree.getRootNode()));
  }

  @Test
  public void testValidBinaryTree2() {
    tree.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
    final List<List<Integer>> expectedList = new ArrayList<>();
    expectedList.add(Arrays.asList(1));
    expectedList.add(Arrays.asList(2, 3));
    expectedList.add(Arrays.asList(4, 5, 6, 7));
    expectedList.add(Arrays.asList(8, 9, 10, 11, 12));

    Assert.assertEquals(expectedList, obj.levelOrder(tree.getRootNode()));
  }
}
