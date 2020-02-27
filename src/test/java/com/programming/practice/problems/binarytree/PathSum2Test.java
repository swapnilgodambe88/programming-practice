package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link PathSum2}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class PathSum2Test {

  private final PathSum2 obj = new PathSum2();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testSolutionExists() {
    final TreeNode root =
        tree.createBinaryTree(
            Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1));

    tree.TopView(root);

    final List<List<Integer>> expectedList = new ArrayList<>();

    expectedList.add(Arrays.asList(5, 4, 11, 2));
    expectedList.add(Arrays.asList(5, 8, 4, 5));
    Assert.assertEquals(expectedList, obj.pathSum(root, 22));
  }

  @Test
  public void testNoSolutionExists1() {
    final TreeNode root =
        tree.createBinaryTree(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 1));

    final List<List<Integer>> expectedList = new ArrayList<>();
    Assert.assertEquals(expectedList, obj.pathSum(root, 100));
  }

  @Test
  public void testNoSolutionExists2() {
    final TreeNode root =
        tree.createBinaryTree(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 1));

    final List<List<Integer>> expectedList = new ArrayList<>();
    Assert.assertEquals(expectedList, obj.pathSum(root, 9));
  }
}
