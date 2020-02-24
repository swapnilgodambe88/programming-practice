package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MergeTwoSortedList}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MergeTwoSortedListTest {

  private final MergeTwoSortedList obj = new MergeTwoSortedList();

  @Test
  public void testOneEmptyList() {
    ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {});
    ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {5, 6, 9});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {5, 6, 9});
    Assert.assertEquals("Assertion failed", expected, obj.mergeTwoLists(l1, l2));
  }

  @Test
  public void testBothEmptyList() {
    ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {});
    ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {});
    Assert.assertEquals("Assertion failed", expected, obj.mergeTwoLists(l1, l2));
  }

  @Test
  public void testValidScenario1() {
    ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 4});
    ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {1, 3, 4});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {1, 1, 2, 3, 4, 4});
    Assert.assertEquals("Assertion failed", expected, obj.mergeTwoLists(l1, l2));
  }

  @Test
  public void testValidScenario2() {
    ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 4});
    ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {11, 12, 13});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {1, 2, 4, 11, 12, 13});
    Assert.assertEquals("Assertion failed", expected, obj.mergeTwoLists(l1, l2));
  }

  @Test
  public void testValidScenario3() {
    ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {11, 12, 13});
    ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 4});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {1, 2, 4, 11, 12, 13});
    Assert.assertEquals("Assertion failed", expected, obj.mergeTwoLists(l1, l2));
  }
}
