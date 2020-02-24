package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link RemoveNthNodeFromEndOfList}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class RemoveNthNodeFromEndOfListTest {
  private final RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();

  @Test
  public void testNGreaterThanZero() {
    ListNode list = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 5});
    Assert.assertEquals("Assertion failed", expected, obj.removeNthFromEnd(list, 2));
  }

  @Test
  public void testNEqualZero() {
    ListNode list = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});
    Assert.assertEquals("Assertion failed", expected, obj.removeNthFromEnd(list, 0));
  }

  @Test
  public void testNGreaterThanListLength() {
    ListNode list = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});
    Assert.assertEquals("Assertion failed", expected, obj.removeNthFromEnd(list, 12));
  }

  @Test
  public void testNEqualsListLength() {
    ListNode list = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {2, 3, 4, 5});
    Assert.assertEquals("Assertion failed", expected, obj.removeNthFromEnd(list, 5));
  }

  @Test
  public void testListSize1NEquals1() {
    ListNode list = ListNode.convertArrayToLinkedList(new int[] {1});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {});
    Assert.assertEquals("Assertion failed", expected, obj.removeNthFromEnd(list, 1));
  }

  @Test
  public void testListSize1NEquals0() {
    ListNode list = ListNode.convertArrayToLinkedList(new int[] {1});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {1});
    Assert.assertEquals("Assertion failed", expected, obj.removeNthFromEnd(list, 0));
  }
}
