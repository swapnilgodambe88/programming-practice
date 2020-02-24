package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MergeKSortedList}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MergeKSortedListTest {

  private final MergeKSortedList obj = new MergeKSortedList();

  @Test
  public void testAllEmptyList() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {});
    final ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {});
    final ListNode l3 = ListNode.convertArrayToLinkedList(new int[] {});

    final ListNode[] lists = new ListNode[] {l1, l2, l3};

    final ListNode expected = ListNode.convertArrayToLinkedList(new int[] {});
    Assert.assertEquals("Assertion failed", expected, obj.mergeKLists(lists));
  }

  @Test
  public void testSingleEmptyList() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 3, 5, 7, 9});
    final ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {});
    final ListNode l3 = ListNode.convertArrayToLinkedList(new int[] {2, 4, 6, 8});

    final ListNode[] lists = new ListNode[] {l1, l2, l3};

    final ListNode expected =
        ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
    Assert.assertEquals("Assertion failed", expected, obj.mergeKLists(lists));
  }

  @Test
  public void testValidScenario() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 4, 7, 10});
    final ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {2, 5, 8});
    final ListNode l3 = ListNode.convertArrayToLinkedList(new int[] {3, 6, 9});

    final ListNode[] lists = new ListNode[] {l1, l2, l3};

    final ListNode expected =
        ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    Assert.assertEquals("Assertion failed", expected, obj.mergeKLists(lists));
  }
}
