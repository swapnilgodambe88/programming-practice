package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link LevelOrderTraversal2}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class LevelOrderTraversal2Test {

  private final LevelOrderTraversal2 obj = new LevelOrderTraversal2();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testEmptyBinaryTree() {
    final List<List<Integer>> expectedList = new ArrayList<>();

    Assert.assertEquals(expectedList, obj.levelOrderBottom(tree.getRootNode()));
  }

  @Test
  public void testValidBinaryTree1() {
    tree.createBinaryTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
    final List<List<Integer>> expectedList = new ArrayList<>();
    expectedList.add(Arrays.asList(15, 7));
    expectedList.add(Arrays.asList(9, 20));
    expectedList.add(Arrays.asList(3));

    Assert.assertEquals(expectedList, obj.levelOrderBottom(tree.getRootNode()));
  }

  @Test
  public void testValidBinaryTree2() {
    tree.createBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
    final List<List<Integer>> expectedList = new ArrayList<>();
    expectedList.add(Arrays.asList(8, 9, 10, 11, 12));
    expectedList.add(Arrays.asList(4, 5, 6, 7));
    expectedList.add(Arrays.asList(2, 3));
    expectedList.add(Arrays.asList(1));

    Assert.assertEquals(expectedList, obj.levelOrderBottom(tree.getRootNode()));
  }
}
