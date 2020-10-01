package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Implement the RandomizedSet class:
 *
 * <ul>
 *   <li>bool insert(int val) Inserts an item val into the set if not present. Returns true if the
 *       item was not present, false otherwise.
 *   <li>bool remove(int val) Removes an item val from the set if present. Returns true if the item
 *       was present, false otherwise.
 *   <li>int getRandom() Returns a random element from the current set of elements (it's guaranteed
 *       that at least one element exists when this method is called). Each element must have the
 *       same probability of being returned.
 * </ul>
 *
 * Follow up: Could you implement the functions of the class with each function works in average
 * O(1) time?
 *
 * <pre>
 * Example 1:
 *
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 *
 * Explanation
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/insert-delete-getrandom-o1/">Insert Delete
 *     GetRandom O(1)</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class RandomizedSet {

  /**
   * A map to store the elements where set-elements are keys and the value would be the index where
   * the element is stored in the list.
   */
  private final Map<Integer, Integer> map;

  /** A list to store the elements. */
  private final List<Integer> list;

  /** A variable to generate random number */
  private final Random random = new Random();

  /** Public constructor for {@link RandomizedSet}. */
  public RandomizedSet() {
    this.map = new HashMap<>();
    this.list = new ArrayList<>();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified
   * element.
   *
   * @param val The value to insert.
   * @return True if the set did not already contain the specified element.
   */
  public boolean insert(final int val) {
    if (map.containsKey(val)) {
      return false;
    }

    final int dataLength = list.size();
    list.add(dataLength, val);
    map.put(val, dataLength);

    return true;
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   *
   * @param val The value to remove.
   * @return True if the set contained the specified element.
   */
  public boolean remove(final int val) {
    if (!map.containsKey(val)) {
      return false;
    }

    final int indexOfElementToRemove = map.get(val);
    final int lastElement = list.get(list.size() - 1);

    // Move the last element to the place where delete needs to happen
    map.put(lastElement, indexOfElementToRemove);
    list.set(indexOfElementToRemove, lastElement);

    // Delete the last element
    map.remove(val);
    list.remove(list.size() - 1);

    return true;
  }

  /** @return A random element from the set. */
  public int getRandom() {
    return list.get(random.nextInt(list.size()));
  }
}
