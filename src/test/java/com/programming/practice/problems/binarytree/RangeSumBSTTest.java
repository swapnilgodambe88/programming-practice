package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link RangeSumBST}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class RangeSumBSTTest {
  private final RangeSumBST obj = new RangeSumBST();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testScenario1() {
    tree.createBinaryTree(Arrays.asList(10, 5, 15, 3, 7, null, 18));

    Assert.assertEquals(32, obj.rangeSumBST(tree.getRootNode(), 7, 15));
  }

  @Test
  public void testScenario2() {
    tree.createBinaryTree(Arrays.asList(10, 5, 15, 3, 7, 13, 18, 1, null, 6));

    Assert.assertEquals(23, obj.rangeSumBST(tree.getRootNode(), 6, 10));
  }
}
