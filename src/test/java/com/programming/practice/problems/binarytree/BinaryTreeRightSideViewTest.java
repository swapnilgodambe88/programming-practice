package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box test for {@link BinaryTreeRightSideView}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BinaryTreeRightSideViewTest {

  private final BinaryTreeRightSideView obj = new BinaryTreeRightSideView();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testEmptyTree() {
    tree.createBinaryTree(Arrays.asList());

    final List<Integer> expectedRightSideView = Arrays.asList();

    Assert.assertEquals(expectedRightSideView, obj.rightSideView(tree.getRootNode()));
  }

  @Test
  public void testScenario1() {
    tree.createBinaryTree(Arrays.asList(1, 2, 3, null, 5, null, 4));

    final List<Integer> expectedRightSideView = Arrays.asList(1, 3, 4);

    Assert.assertEquals(expectedRightSideView, obj.rightSideView(tree.getRootNode()));
  }
}
