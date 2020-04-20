package com.programming.practice.problems.misc;

import com.programming.practice.datastructure.TrieNode;
import java.util.Objects;

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

  private static final char START = '-';

  private final TrieNode root;

  /** Public constructor for {@link ImplementTrie}. */
  public ImplementTrie() {
    this.root = new TrieNode(START);
  }

  /**
   * Inserts a word into the trie.
   *
   * @param word The word to insert.
   */
  public void insert(final String word) {

    TrieNode curNode = root;

    for (final char character : word.toCharArray()) {
      if (Objects.isNull(curNode.children[character - 'a'])) {
        curNode.children[character - 'a'] = new TrieNode(character);
      }

      curNode = curNode.children[character - 'a'];
    }

    curNode.endOfWord = true;
  }

  /**
   * Evaluates if the trie contains the word or not.
   *
   * @param word The word to search.
   * @return True If the word is present in trie. False, otherwise.
   */
  public boolean search(final String word) {

    TrieNode curNode = root;

    for (final char character : word.toCharArray()) {
      if (!Objects.isNull(curNode.children[character - 'a'])) {
        curNode = curNode.children[character - 'a'];
      } else {
        return false;
      }
    }

    return curNode.endOfWord;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   *
   * @param prefix The prefix to search in trie.
   * @return True If there exists any word in trie with the given prefix. False, otherwise.
   */
  public boolean startsWith(final String prefix) {

    TrieNode curNode = root;

    for (final char character : prefix.toCharArray()) {
      if (!Objects.isNull(curNode.children[character - 'a'])) {
        curNode = curNode.children[character - 'a'];
      } else {
        return false;
      }
    }

    return true;
  }
}
