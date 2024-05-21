package com.programming.practice.problems.binarytree;

import com.programming.practice.datastructure.BinaryTree;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/** Unit tests for {@link PostOrderTraversal}. */
public class PostOrderTraversalTest {
  private final PostOrderTraversal obj = new PostOrderTraversal();

  private final BinaryTree tree = new BinaryTree();

  @Test
  public void testEmptyTree() {
    final List<Integer> expectedTraversal = new ArrayList<>();
    Assert.assertEquals(expectedTraversal, obj.postorderTraversal(tree.getRootNode()));
  }

  @Test
  public void testScenario1() {
    tree.createBinaryTree(List.of(1, null, 2, null, null, 3));
    final List<Integer> expectedTraversal = List.of(3, 2, 1);

    Assert.assertEquals(expectedTraversal, obj.postorderTraversal(tree.getRootNode()));
  }

  @Test
  public void testSingleRootElementTree() {
    tree.createBinaryTree(List.of(1));
    final List<Integer> expectedTraversal = List.of(1);

    Assert.assertEquals(expectedTraversal, obj.postorderTraversal(tree.getRootNode()));
  }
}
