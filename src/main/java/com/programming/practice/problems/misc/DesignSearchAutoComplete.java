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
 * Design a search autocomplete system for a search engine. Users may input a sentence (at least one
 * word and end with a special character '#'). For each character they type except '#', you need to
 * return the top 3 historical hot sentences that have prefix the same as the part of sentence
 * already typed. Here are the specific rules:
 *
 * <ul>
 *   <li>The hot degree for a sentence is defined as the number of times a user typed the exactly
 *       same sentence before.
 *   <li>The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest
 *       one). If several sentences have the same degree of hot, you need to use ASCII-code order
 *       (smaller one appears first).
 *   <li>If less than 3 hot sentences exist, then just return as many as you can.
 *   <li>When the input is a special character, it means the sentence ends, and in this case, you
 *       need to return an empty list.
 * </ul>
 *
 * Your job is to implement the following functions:<br>
 * The constructor function:<br>
 *
 * <p>AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is
 * historical data. Sentences is a string array consists of previously typed sentences. Times is the
 * corresponding times a sentence has been typed. Your system should record these historical data.
 *
 * <p>Now, the user wants to input a new sentence. The following function will provide the next
 * character the user types:
 *
 * <p>List<String> input(char c): The input c is the next character typed by the user. The character
 * will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#').
 * Also, the previously typed sentence should be recorded in your system. The output will be the top
 * 3 historical hot sentences that have prefix the same as the part of sentence already typed.
 *
 * <pre>
 * Example:
 * Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
 * The system have already tracked down the following sentences and their corresponding times:
 * "i love you" : 5 times
 * "island" : 3 times
 * "ironman" : 2 times
 * "i love leetcode" : 2 times
 * Now, the user begins another search:
 *
 * Operation: input('i')
 * Output: ["i love you", "island","i love leetcode"]
 * Explanation:
 * There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
 *
 * Operation: input(' ')
 * Output: ["i love you","i love leetcode"]
 * Explanation:
 * There are only two sentences that have prefix "i ".
 *
 * Operation: input('a')
 * Output: []
 * Explanation:
 * There are no sentences that have prefix "i a".
 *
 * Operation: input('#')
 * Output: []
 * Explanation:
 * The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/design-search-autocomplete-system/">Design Search
 *     Autocomplete system</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class DesignSearchAutoComplete {

  private static final char START = '-';

  /** Class representing a Trie node. */
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
    final Comparator<Map.Entry<String, Integer>> comparator =
        (a, b) -> {
          if (!a.getValue().equals(b.getValue())) {
            return b.getValue().intValue() - a.getValue().intValue();
          }

          return a.getKey().compareTo(b.getKey());
        };

    return frequencyMap.entrySet().stream()
        .filter(predicate)
        .sorted(comparator)
        .map(entry -> entry.getKey())
        .limit(3)
        .collect(Collectors.toList());
  }
}
