package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link AddTwoNumbers}.
 *
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
public final class AddTwoNumbersTest {

  private final AddTwoNumbers obj = new AddTwoNumbers();

  @Test
  public void testEqualSizeList() {
    ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {2, 4, 3});
    ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {5, 6, 4});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {7, 0, 8});
    Assert.assertEquals("Assertion failed", expected, obj.addTwoNumbers(l1, l2));
  }

  @Test
  public void testUnequalSizeList() {
    ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1});
    ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {9, 9});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {0, 0, 1});
    Assert.assertEquals("Assertion failed", expected, obj.addTwoNumbers(l1, l2));
  }

  @Test
  public void testEmptyList() {
    ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {});
    ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {});
    Assert.assertEquals("Assertion failed", expected, obj.addTwoNumbers(l1, l2));
  }

  @Test
  public void testOneEmptyList() {
    ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {});
    ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {9, 4, 6, 7});

    ListNode expected = l2;
    Assert.assertEquals("Assertion failed", expected, obj.addTwoNumbers(l1, l2));
  }
}
