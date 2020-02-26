package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link AddTwoNumbers}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class AddTwoNumbersTest {

  private final AddTwoNumbers obj = new AddTwoNumbers();

  @Test
  public void testEqualSizeList() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {2, 4, 3});
    final ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {5, 6, 4});

    final ListNode expected = ListNode.convertArrayToLinkedList(new int[] {7, 0, 8});
    Assert.assertEquals("Assertion failed", expected, obj.addTwoNumbers(l1, l2));
  }

  @Test
  public void testUnequalSizeList1() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1});
    final ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {9, 9});

    final ListNode expected = ListNode.convertArrayToLinkedList(new int[] {0, 0, 1});
    Assert.assertEquals("Assertion failed", expected, obj.addTwoNumbers(l1, l2));
  }

  @Test
  public void testUnequalSizeList2() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {9, 9, 3, 9});
    final ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {1});

    final ListNode expected = ListNode.convertArrayToLinkedList(new int[] {0, 0, 4, 9});
    Assert.assertEquals("Assertion failed", expected, obj.addTwoNumbers(l1, l2));
  }

  @Test
  public void testEmptyList() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {});
    final ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {});

    final ListNode expected = ListNode.convertArrayToLinkedList(new int[] {});
    Assert.assertEquals("Assertion failed", expected, obj.addTwoNumbers(l1, l2));
  }

  @Test
  public void testOneEmptyList() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {});
    final ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {9, 4, 6, 7});

    final ListNode expected = l2;
    Assert.assertEquals("Assertion failed", expected, obj.addTwoNumbers(l1, l2));
  }
}
