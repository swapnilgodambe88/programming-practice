package com.programming.practice.datastructure;

import java.util.Objects;

/**
 * A class representing a node on Trie.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class TrieNode {

  public final char character;
  public final TrieNode[] children;
  public boolean endOfWord;

  public TrieNode(final char character) {
    this.character = character;
    this.children = new TrieNode[26];
    this.endOfWord = false;
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode() {
    return Objects.hash(this.character, this.children, this.endOfWord);
  }

  /** {@inheritDoc} */
  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof TrieNode)) {
      return false;
    }

    final TrieNode other = (TrieNode) object;
    if (this.character != other.character) {
      return false;
    }

    if (this.endOfWord != other.endOfWord) {
      return false;
    }

    if (!Objects.deepEquals(this.children, other.children)) {
      return false;
    }

    return true;
  }
}
