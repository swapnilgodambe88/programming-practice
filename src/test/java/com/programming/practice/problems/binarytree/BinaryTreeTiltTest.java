package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BinaryTreeTilt}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BinaryTreeTiltTest {

  private final BinaryTree tree = new BinaryTree();
  private final BinaryTreeTilt obj = new BinaryTreeTilt();

  @Test
  public void testScenario1() {
    tree.createBinaryTree(Arrays.asList(1, 2, 3));

    Assert.assertEquals(1, obj.findTilt(tree.getRootNode()));
  }

  @Test
  public void testScenario2() {
    tree.createBinaryTree(Arrays.asList(4, 2, 9, 3, 5, null, 7));

    Assert.assertEquals(15, obj.findTilt(tree.getRootNode()));
  }
}
