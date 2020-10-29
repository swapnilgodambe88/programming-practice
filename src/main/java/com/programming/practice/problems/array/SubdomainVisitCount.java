package com.programming.practice.problems.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we
 * have "com", at the next level, we have "leetcode.com", and at the lowest level,
 * "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit
 * the parent domains "leetcode.com" and "com" implicitly.
 *
 * <p>Now, call a "count-paired domain" to be a count (representing the number of visits this domain
 * received), followed by a space, followed by the address. An example of a count-paired domain
 * might be "9001 discuss.leetcode.com".
 *
 * <p>We are given a list cpdomains of count-paired domains. We would like a list of count-paired
 * domains, (in the same format as the input, and in any order), that explicitly counts the number
 * of visits to each subdomain.
 *
 * <pre>
 * Example 1:
 * Input:
 * ["9001 discuss.leetcode.com"]
 * Output:
 * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * Explanation:
 * We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
 *
 * Example 2:
 * Input:
 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * Output:
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * Explanation:
 * We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/subdomain-visit-count/">Subdomain visit count</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SubdomainVisitCount {

  /**
   * Returns a list of count-paired domains, (in the same format as the input, and in any order),
   * that explicitly counts the number of visits to each subdomain.
   *
   * @param cpdomains An array list of cp domains.
   * @return A list of count-paired domains, (in the same format as the input, and in any order),
   *     that explicitly counts the number of visits to each subdomain.
   */
  public List<String> subdomainVisits(final String[] cpdomains) {
    final Map<String, Integer> subdomainCountMap = new HashMap<>();

    for (final String cpdomain : cpdomains) {
      final String[] splitString = cpdomain.split("\\s");

      final int cpdomainCount = Integer.valueOf(splitString[0]);
      final String[] subdomains = splitString[1].split("\\.");

      String currentSubdomain = "";
      for (int i = subdomains.length - 1; i >= 0; --i) {
        if (currentSubdomain.length() != 0) {
          currentSubdomain = subdomains[i] + "." + currentSubdomain;
        } else {
          currentSubdomain = subdomains[i];
        }

        final int count = subdomainCountMap.getOrDefault(currentSubdomain, 0);
        subdomainCountMap.put(currentSubdomain, count + cpdomainCount);
      }
    }

    return subdomainCountMap.entrySet().stream()
        .map(entry -> new String(entry.getValue() + " " + entry.getKey()))
        .collect(Collectors.toList());
  }
}
