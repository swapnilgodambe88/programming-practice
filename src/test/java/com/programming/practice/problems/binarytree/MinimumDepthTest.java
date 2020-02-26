package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MinimumDepth}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MinimumDepthTest {

  private final MinimumDepth obj = new MinimumDepth();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testEmptyTree() {
    Assert.assertEquals(0, obj.minDepth(tree.getRootNode()));
  }

  @Test
  public void testScenario1() {
    tree.createBinaryTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
    Assert.assertEquals(2, obj.minDepth(tree.getRootNode()));
  }

  @Test
  public void testScenario2() {
    tree.createBinaryTree(Arrays.asList(1, 2));
    Assert.assertEquals(2, obj.minDepth(tree.getRootNode()));
  }

  @Test
  public void testSingleNodeTree() {
    tree.addNodeToTree(10);
    Assert.assertEquals(1, obj.minDepth(tree.getRootNode()));
  }
}
