package com.programming.practice.problems.misc;

import com.programming.practice.datastructure.TrieNode;
import java.util.Objects;

/**
 * Design a data structure that supports the following two operations:
 *
 * <pre>
 * void addWord(word)
 * bool search(word)
 * </pre>
 *
 * search(word) can search a literal word or a regular expression string containing only letters a-z
 * or .. A . means it can represent any one letter.
 *
 * <pre>
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/add-and-search-word-data-structure-design/">Add and
 *     Search Word - Data structure design</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class AddAndSearchWord {

  private static final char START = '-';
  private final TrieNode root;

  /** Constructor for {@link AddAndSearchWord}. */
  public AddAndSearchWord() {
    this.root = new TrieNode(START);
  }

  /**
   * Adds the given word to the trie.
   *
   * @param word The word to insert.
   */
  public void addWord(final String word) {

    TrieNode pointer = this.root;

    for (final char character : word.toCharArray()) {

      if (Objects.isNull(pointer.children[character - 'a'])) {
        pointer.children[character - 'a'] = new TrieNode(character);
      }

      pointer = pointer.children[character - 'a'];
    }
    pointer.endOfWord = true;
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to
   * represent any one letter.
   *
   * @param word The word to search in the Trie.
   * @returns True If the word is present on the trie. False, otherwise.
   */
  public boolean search(final String word) {
    return recursiveSearch(this.root, word, 0);
  }

  /**
   * A recursive search function.
   *
   * @param currentNode The current {@link TrieNode}.
   * @param word The word.
   * @param currentIndex The current index to be evaluated on the word.
   * @return True if the word is present on the trie.
   */
  private boolean recursiveSearch(
      final TrieNode currentNode, final String word, final int currentIndex) {
    if (currentIndex == word.length()) {
      return currentNode.endOfWord;
    }

    final char currentCharacter = word.charAt(currentIndex);
    if (currentCharacter != '.') {
      if (Objects.isNull(currentNode.children[currentCharacter - 'a'])) {
        return false;
      }

      return recursiveSearch(currentNode.children[currentCharacter - 'a'], word, currentIndex + 1);
    }

    for (final TrieNode neighbor : currentNode.children) {
      if (neighbor != null && recursiveSearch(neighbor, word, currentIndex + 1)) {
        return true;
      }
    }

    return false;
  }
}
