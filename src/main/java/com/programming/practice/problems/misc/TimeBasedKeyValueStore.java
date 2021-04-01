package com.programming.practice.problems.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Create a timebased key-value store class TimeMap, that supports two operations.
 *
 * <ol>
 *   <li>set(string key, string value, int timestamp)
 *       <ul>
 *         <li>Stores the key and value, along with the given timestamp.
 *       </ul>
 *   <li>get(string key, int timestamp)
 *       <ul>
 *         <li>Returns a value such that set(key, value, timestamp_prev) was called previously, with
 *             timestamp_prev <= timestamp.
 *         <li>If there are multiple such values, it returns the one with the largest
 *             timestamp_prev.
 *         <li>If there are no values, it returns the empty string ("").
 *       </ul>
 * </ol>
 *
 * <pre>
 * Example 1:
 *
 * Input: inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * Output: [null,null,"bar","bar",null,"bar2","bar2"]
 * Explanation:
 * TimeMap kv;
 * kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
 * kv.get("foo", 1);  // output "bar"
 * kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"
 * kv.set("foo", "bar2", 4);
 * kv.get("foo", 4); // output "bar2"
 * kv.get("foo", 5); //output "bar2"
 *
 * Example 2:
 *
 * Input: inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
 * Output: [null,null,null,"","high","high","low","low"]
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/time-based-key-value-store/">Time Based Key-Value
 *     Store</a>
 */
public class TimeBasedKeyValueStore {

  /**
   * Map used to store the historical information of a key-value. Map<Key, TreeMap<TimeStamp,
   * Value>>.
   */
  private final Map<String, TreeMap<Integer, String>> map;

  /** Constructor for {@link TimeBasedKeyValueStore}. */
  public TimeBasedKeyValueStore() {
    map = new HashMap<>();
  }

  /**
   * Sets the key with the given value with the associated timestamp.
   *
   * @param key The key.
   * @param value The value.
   * @param timestamp The timestamp.
   */
  public void set(String key, String value, int timestamp) {
    if (!map.containsKey(key)) {
      map.put(key, new TreeMap<>());
    }

    map.get(key).put(timestamp, value);
  }

  /**
   * Gets the value corresponding to the key.
   *
   * @param key The key.
   * @param timestamp The reference timestamp.
   * @return The value corresponding to the key.
   */
  public String get(String key, int timestamp) {
    if (map.containsKey(key)) {
      final TreeMap<Integer, String> treeMap = map.get(key);

      final Integer floorKey = treeMap.floorKey(timestamp);
      return floorKey != null ? treeMap.get(floorKey) : "";
    }

    return "";
  }
}
