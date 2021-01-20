package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link DiameterOfBinaryTree}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class DiameterOfBinaryTreeTest {

  private final DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testScenario1() {
    final List<Integer> nodeList = Arrays.asList(1, 2, 3, 4, 5);

    final TreeNode root1 = tree.createBinaryTree(nodeList);

    Assert.assertEquals(3, obj.diameterOfBinaryTree(tree.getRootNode()));
  }

  @Test
  public void testScenario2() {
    Assert.assertEquals(0, obj.diameterOfBinaryTree(tree.getRootNode()));
  }

  @Test
  public void testScenario3() {
    final List<Integer> nodeList = Arrays.asList(2, 3, null, 1);
    final TreeNode root1 = tree.createBinaryTree(nodeList);

    Assert.assertEquals(2, obj.diameterOfBinaryTree(tree.getRootNode()));
  }
}
