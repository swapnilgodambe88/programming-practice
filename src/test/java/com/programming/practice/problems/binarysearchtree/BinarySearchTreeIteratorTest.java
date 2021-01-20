package com.programming.practice.problems.binarysearchtree;

import com.programming.practice.datastructure.BinarySearchTree;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link
 * com.programming.practice.problems.binarysearchtree.BinarySearchTreeIterator}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BinarySearchTreeIteratorTest {

  private final BinarySearchTree tree = new BinarySearchTree();

  @Test
  public void testScenario() {
    tree.createBinaryTree(Arrays.asList(10, 9, 8, 7, 6, 12, 13));

    final BinarySearchTreeIterator obj = new BinarySearchTreeIterator(tree.getRootNode());

    Assert.assertTrue(obj.hasNext());
    Assert.assertEquals(6, obj.next());
    Assert.assertEquals(7, obj.next());
    Assert.assertEquals(8, obj.next());
    Assert.assertEquals(9, obj.next());
    Assert.assertEquals(10, obj.next());
    Assert.assertEquals(12, obj.next());
    Assert.assertEquals(13, obj.next());

    Assert.assertFalse(obj.hasNext());
  }

  @Test
  public void testHasNextThrowsException() {
    tree.addNodeToTree(1);

    final BinarySearchTreeIterator obj = new BinarySearchTreeIterator(tree.getRootNode());

    obj.next();

    Assert.assertThrows(
        "End of iterator reached. No next element available",
        UnsupportedOperationException.class,
        () -> {
          obj.next();
        });
  }
}
