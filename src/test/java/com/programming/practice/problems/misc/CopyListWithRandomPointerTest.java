package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link CopyListWithRandomPointer}.
 *
 * @author Swapnil Godambe.<br>
 *         Copyright 2020.
 */
public final class CopyListWithRandomPointerTest {

  private final CopyListWithRandomPointer obj = new CopyListWithRandomPointer();

  @Test
  public void testScenario1() {
    final CopyListWithRandomPointer.Node node1 = obj.new Node(7);
    final CopyListWithRandomPointer.Node node2 = obj.new Node(13);
    final CopyListWithRandomPointer.Node node3 = obj.new Node(11);
    final CopyListWithRandomPointer.Node node4 = obj.new Node(12);
    final CopyListWithRandomPointer.Node node5 = obj.new Node(1);

    node1.next = node2;
    node2.next = node3;
    node2.random = node1;
    node3.next = node4;
    node3.random = node5;
    node4.next = node5;
    node4.random = node3;
    node5.random = node1;

    final CopyListWithRandomPointer.Node copyNode1 = obj.copyRandomList(node1);

    Assert.assertEquals(7, copyNode1.val);
    Assert.assertEquals(13, copyNode1.next.val);
    Assert.assertNull(copyNode1.random);

  }
}
