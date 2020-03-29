package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ReverseLinkedList}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ReverseNodesInLinkedListTest {

  private final ReverseLinkedList obj = new ReverseLinkedList();

  @Test
  public void testEmptyLinkedList() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {});

    final ListNode expectedReverseListNode = ListNode.convertArrayToLinkedList(new int[] {});
    Assert.assertEquals(expectedReverseListNode, obj.reverseList(l1));
  }

  @Test
  public void testSingleNode() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1});

    final ListNode expectedReverseListNode = ListNode.convertArrayToLinkedList(new int[] {1});
    Assert.assertEquals(expectedReverseListNode, obj.reverseList(l1));
  }

  @Test
  public void testScenario1() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});

    final ListNode expectedReverseListNode =
        ListNode.convertArrayToLinkedList(new int[] {5, 4, 3, 2, 1});
    Assert.assertEquals(expectedReverseListNode, obj.reverseList(l1));
  }

  @Test
  public void testScenario2() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {5, 4, 3, 2, 1});

    final ListNode expectedReverseListNode =
        ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});
    Assert.assertEquals(expectedReverseListNode, obj.reverseList(l1));
  }

  @Test
  public void testAllNodesEqual() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 1, 1, 1});

    final ListNode expectedReverseListNode =
        ListNode.convertArrayToLinkedList(new int[] {1, 1, 1, 1});
    Assert.assertEquals(expectedReverseListNode, obj.reverseList(l1));
  }
}
