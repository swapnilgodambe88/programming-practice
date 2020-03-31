package com.programming.practice.problems.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * <p>Example:
 *
 * <pre>
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple"); // returns true
 * trie.search("app"); // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app"); // returns true
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/implement-trie-prefix-tree/">Implement Trie (Prefix
 *     Tree)</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class ImplementTrie {

  private static final char START = 'a';

  class TrieNode {
    public final char value;
    public final Map<Character, TrieNode> children;
    public boolean endOfWord;

    public TrieNode(final char value) {
      this.value = value;
      this.children = new HashMap<>();
      this.endOfWord = false;
    }
  }

  private final TrieNode root;

  /** Public constructor for {@link ImplementTrie}. */
  public ImplementTrie() {
    this.root = new TrieNode(START);
  }

  /** Inserts a word into the trie. */
  public void insert(final String word) {

    TrieNode curNode = root;
    for (final char character : word.toCharArray()) {
      if (!curNode.children.containsKey(character)) {
        final TrieNode node = new TrieNode(character);
        curNode.children.put(character, node);
      }

      curNode = curNode.children.get(character);
    }

    curNode.endOfWord = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(final String word) {

    TrieNode curNode = root;
    for (final char character : word.toCharArray()) {
      if (curNode.children.containsKey(character)) {
        curNode = curNode.children.get(character);
      } else {
        return false;
      }
    }

    return curNode.endOfWord;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(final String prefix) {

    TrieNode curNode = root;
    for (final char character : prefix.toCharArray()) {
      if (curNode.children.containsKey(character)) {
        curNode = curNode.children.get(character);
      } else {
        return false;
      }
    }

    return true;
  }
}
