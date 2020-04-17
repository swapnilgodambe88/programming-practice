package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @see <a href = ""></a>
 * @author Swapnil Godambe.<br>
 *         Copyright 2020.
 */
public final class DesignSearchAutoComplete {

  private static final char START = '-';

  /**
   * Class representing a Trie node.
   */
  class TrieNode {
    public char character;
    public Map<Character, TrieNode> children;
    public Set<String> endSentences;

    /**
     * Constructor for {@link TrieNode}.
     *
     * @param character The character associated to the trie node.
     */
    public TrieNode(final char character) {
      this.character = character;
      this.children = new HashMap<>();
      this.endSentences = new HashSet<>();
    }
  }

  /**
   * Class representing a sentence and it's frequency.
   */
  class SentenceFrequency {
    public final String sentence;
    public final int frequency;

    /**
     * Constructor for {@link SentenceFrequency}.
     *
     * @param sentence The sentence.
     * @param frequency The frequency.
     */
    public SentenceFrequency(final String sentence, final int frequency) {
      this.sentence = sentence;
      this.frequency = frequency;
    }
  }

  private final TrieNode root;
  private final Map<String, Integer> frequencyMap;
  private StringBuffer currentSentence;
  private TrieNode currentTrieNode;

  /**
   * Constructor for {@link DesignSearchAutoComplete}.
   *
   * @param sentences The list of initial sentences.
   * @param times The frequencies associated to the sentences.
   */
  public DesignSearchAutoComplete(final String[] sentences, final int[] times) {
    this.root = new TrieNode(START);
    this.frequencyMap = new HashMap<>();
    this.currentSentence = new StringBuffer();
    this.currentTrieNode = this.root;

    // Add initial sentences with their frequency in the memory
    for (int i = 0; i < sentences.length; ++i) {
      addSentenceToTrie(sentences[i]);
      frequencyMap.put(sentences[i], times[i]);
    }
  }

  /**
   * Returns atleast 3 hot sentences for the input character.
   *
   * @param c The character.
   * @return Hot sentences with the character prefix.
   */
  public List<String> input(final char c) {
    // End of sentence
    if (c == '#') {
      addSentenceToTrie(currentSentence.toString());
      currentSentence = new StringBuffer();
      currentTrieNode = root;
      return new ArrayList<>();
    }

    currentSentence.append(c);
    if (currentTrieNode.children.containsKey(c)) {
      currentTrieNode = currentTrieNode.children.get(c);
      return getHotSentences(currentTrieNode.endSentences);
    }

    // Character is not present in Trie. Add the character and return empty list.
    currentTrieNode.children.put(c, new TrieNode(c));
    currentTrieNode = currentTrieNode.children.get(c);
    return new ArrayList<>();
  }

  /**
   * Adds the sentence to the Trie.
   *
   * @param sentence THe sentence to add.
   */
  private void addSentenceToTrie(final String sentence) {
    TrieNode curNode = this.root;

    // Add sentence to the trie
    for (final char character : sentence.toCharArray()) {

      if (!curNode.children.containsKey(character)) {
        curNode.children.put(character, new TrieNode(character));
      }
      curNode = curNode.children.get(character);
    }

    // Add the sentence to each trie node
    curNode = this.root;
    for (final char character : sentence.toCharArray()) {
      curNode = curNode.children.get(character);
      curNode.endSentences.add(sentence);
    }

    // Add entry to map
    final int count = frequencyMap.getOrDefault(sentence, 0);
    frequencyMap.put(sentence, count + 1);
  }

  /**
   * Sorts the sentences based on the hotness quotient and returns the first 3 hot sentences.
   *
   * @param sentences The set of sentences.e
   * @return The first 3 hot sentences.
   */
  private List<String> getHotSentences(final Set<String> sentences) {

    // Predicate to filter out map entries not matching endSentences
    final Predicate<Map.Entry<String, Integer>> predicate =
        entry -> sentences.contains(entry.getKey());

        // Comparator to sort the map entries based on frequency and lexographically.
        final Comparator<Map.Entry<String, Integer>> comparator = (a, b) -> {
          if (!a.getValue().equals(b.getValue())) {
            return b.getValue().intValue() - a.getValue().intValue();
          }

          return a.getKey().compareTo(b.getKey());
        };

        return frequencyMap.entrySet().stream().filter(predicate).sorted(comparator)
            .map(entry -> entry.getKey()).limit(3).collect(Collectors.toList());
  }
}
