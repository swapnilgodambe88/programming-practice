package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

/** Unit tests for {@link RemoveDuplicatesFromSortedList}. */
public final class RemoveDuplicatesFromSortedListTest {

  private final RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();

  @Test
  public void testScenario1() {
    final ListNode inputSortedList = ListNode.convertArrayToLinkedList(new int[] {1, 1, 2});
    final ListNode expectedOutput = ListNode.convertArrayToLinkedList(new int[] {1, 2});

    Assert.assertEquals(expectedOutput, obj.deleteDuplicates(inputSortedList));
  }

  @Test
  public void testScenario2() {
    final ListNode inputSortedList = ListNode.convertArrayToLinkedList(new int[] {1, 1, 2, 3, 3});
    final ListNode expectedOutput = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3});

    Assert.assertEquals(expectedOutput, obj.deleteDuplicates(inputSortedList));
  }

  @Test
  public void testSingleElementLinkedList() {
    final ListNode inputSortedList = ListNode.convertArrayToLinkedList(new int[] {1});
    final ListNode expectedOutput = ListNode.convertArrayToLinkedList(new int[] {1});

    Assert.assertEquals(expectedOutput, obj.deleteDuplicates(inputSortedList));
  }

  @Test
  public void testSameRepeatingElement() {
    final ListNode inputSortedList =
        ListNode.convertArrayToLinkedList(new int[] {2, 2, 2, 2, 2, 2});
    final ListNode expectedOutput = ListNode.convertArrayToLinkedList(new int[] {2});

    Assert.assertEquals(expectedOutput, obj.deleteDuplicates(inputSortedList));
  }

  @Test
  public void testEmptyLinkedList() {
    final ListNode inputSortedList = ListNode.convertArrayToLinkedList(new int[] {});

    Assert.assertEquals(inputSortedList, obj.deleteDuplicates(inputSortedList));
  }
}
