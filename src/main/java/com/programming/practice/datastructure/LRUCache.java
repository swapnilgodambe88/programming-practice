package com.programming.practice.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
 * following operations: get and put.
 *
 * <p>get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1. put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before
 * inserting a new item.
 *
 * <p>The cache is initialized with a positive capacity.
 *
 * <p>Follow up: Could you do both operations in O(1) time complexity?
 *
 * <p>Example:
 *
 * <p>LRUCache cache = new LRUCache( 2 );
 *
 * <p>cache.put(1, 1); <br>
 * cache.put(2, 2); <br>
 * cache.get(1); // returns 1<br>
 * cache.put(3, 3); // evicts key 2<br>
 * cache.get(2); // returns -1 (not found)<br>
 * cache.put(4, 4); // evicts key 1<br>
 * cache.get(1); // returns -1 (not found)<br>
 * cache.get(3); // returns 3<br>
 * cache.get(4); // returns 4
 *
 * @see <a href = "https://leetcode.com/problems/lru-cache/">LRU Cache</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.<br>
 * @company eBay
 */
public final class LRUCache {

  /**
   * Class representing a key-value pair.
   *
   * @author Swapnil Godambe.<br>
   *     Copyright 2020.
   */
  final class KeyValue {
    public final int key;
    public final int value;

    /**
     * Constructor for {@link KeyValue}.
     *
     * @param key
     * @param value
     */
    public KeyValue(final int key, final int value) {
      this.key = key;
      this.value = value;
    }
  }

  private final Map<Integer, DoublyLinkedList<KeyValue>.DDLNode> keyToDLLNodeMap;
  private final DoublyLinkedList<KeyValue> dll;
  private final int capacity;

  /**
   * Constructor for {@link LRUCache}.
   *
   * @param capacity The capacity of the cache.
   */
  public LRUCache(final int capacity) {
    this.capacity = capacity;
    keyToDLLNodeMap = new HashMap<>();
    dll = new DoublyLinkedList<>();
  }

  /**
   * @param key The key on the cache.
   * @return The value associated with the key. -1 is key is not present on the cache.
   */
  public int get(final int key) {
    if (!keyToDLLNodeMap.containsKey(key)) {
      return -1;
    }

    final int valueToReturn = keyToDLLNodeMap.get(key).value.value;

    dll.removeDDLNode(keyToDLLNodeMap.get(key));
    keyToDLLNodeMap.remove(key);

    keyToDLLNodeMap.put(key, dll.addToHead(new KeyValue(key, valueToReturn)));

    return valueToReturn;
  }

  /**
   * Inserts the key value pair to the cache.
   *
   * @param key The key.
   * @param value The value.
   */
  public void put(final int key, final int value) {

    if (keyToDLLNodeMap.containsKey(key)) // Map contains the key. Overwrite it with the new value
    {

      // remove the entry from list
      dll.removeDDLNode(keyToDLLNodeMap.get(key));
      keyToDLLNodeMap.remove(key);

    } else if (keyToDLLNodeMap.size() == capacity) // Cache is full and need to remove least
    // recently used value
    {

      final KeyValue keyValueToRemove = dll.removeFromTail();
      // Remove the key from map
      keyToDLLNodeMap.remove(keyValueToRemove.key);
    }

    keyToDLLNodeMap.put(key, dll.addToHead(new KeyValue(key, value)));
  }
}
