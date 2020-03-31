package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ReorderList}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ReorderListTest {

  private final ReorderList obj = new ReorderList();

  @Test
  public void testEmptyLinkedList() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {});
    final ListNode expected = ListNode.convertArrayToLinkedList(new int[] {});

    obj.reorderList(l1);
    Assert.assertEquals(expected, l1);
  }

  @Test
  public void testScenario1() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4});
    final ListNode expected = ListNode.convertArrayToLinkedList(new int[] {1, 4, 2, 3});

    obj.reorderList(l1);
    Assert.assertEquals(expected, l1);
  }

  @Test
  public void testScenario2() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});
    final ListNode expected = ListNode.convertArrayToLinkedList(new int[] {1, 5, 2, 4, 3});

    obj.reorderList(l1);
    Assert.assertEquals(expected, l1);
  }
}
