package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link OddEvenLinkedList}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class OddEvenLinkedListTest {

  private final OddEvenLinkedList obj = new OddEvenLinkedList();

  @Test
  public void testEmptyList() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {});
    final ListNode expectedList = ListNode.convertArrayToLinkedList(new int[] {});

    Assert.assertEquals(expectedList, obj.oddEvenList(l1));
  }

  @Test
  public void testOddLengthList() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5});
    final ListNode expectedList = ListNode.convertArrayToLinkedList(new int[] {1, 3, 5, 2, 4});

    Assert.assertEquals(expectedList, obj.oddEvenList(l1));
  }

  @Test
  public void testEvenLengthList() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5, 6});
    final ListNode expectedList = ListNode.convertArrayToLinkedList(new int[] {1, 3, 5, 2, 4, 6});

    Assert.assertEquals(expectedList, obj.oddEvenList(l1));
  }

  @Test
  public void testSingleNode() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1});
    final ListNode expectedList = ListNode.convertArrayToLinkedList(new int[] {1});

    Assert.assertEquals(expectedList, obj.oddEvenList(l1));
  }
}
