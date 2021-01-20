package com.programming.practice.problems.binarysearchtree;

import com.programming.practice.datastructure.BinarySearchTree;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ClosestBinarySearchTreeValue}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class ClosestBinarySearchTreeValueTest {

  private final ClosestBinarySearchTreeValue obj = new ClosestBinarySearchTreeValue();
  private final BinarySearchTree tree = new BinarySearchTree();

  @Test
  public void testScenario1() {
    tree.createBinaryTree(Arrays.asList(4, 2, 5, 1, 3));

    Assert.assertEquals(4, obj.closestValue(tree.getRootNode(), 3.714286));
  }
}
