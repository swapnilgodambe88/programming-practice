package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ReverseNodesInKGroup}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ReverseNodesInKGroupTest {

  private final ReverseNodesInKGroup obj = new ReverseNodesInKGroup();

  @Test
  public void testKGreaterThanNumberOfNodes() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});
    final ListNode expected = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});

    Assert.assertEquals(expected, obj.reverseKGroup(l1, 12));
  }

  @Test
  public void testKEquals1() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});
    final ListNode expected = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});

    Assert.assertEquals(expected, obj.reverseKGroup(l1, 1));
  }

  @Test
  public void testEmptyList() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {});
    final ListNode expected = ListNode.convertArrayToLinkedList(new int[] {});

    Assert.assertEquals(expected, obj.reverseKGroup(l1, 2));
  }

  @Test
  public void testScenario1() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});
    final ListNode expected = ListNode.convertArrayToLinkedList(new int[] {2, 1, 4, 3, 5});

    Assert.assertEquals(expected, obj.reverseKGroup(l1, 2));
  }

  @Test
  public void testScenario2() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5, 6});
    final ListNode expected = ListNode.convertArrayToLinkedList(new int[] {2, 1, 4, 3, 6, 5});

    Assert.assertEquals(expected, obj.reverseKGroup(l1, 2));
  }
}
