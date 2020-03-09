package com.programming.practice.interview.questions;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given a list of competitors and reviews, parse the reviews for any mention of any competitors.
 * Return back the N top competitors. Review containing multiple mentions of the competitor will be
 * considered as one count.
 *
 * <p>NOTE: If two competitors have a tie, then return them in chronological order of the competitor
 * name. If N > number of competitors then return the list of all competitors.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class TopNCompetitors {

  /**
   * Gets the top N competitors based on the mentions on the review.
   *
   * @param numerOfCompetitorsToReturn The number of competitors to return.
   * @param competitors The list of competitors.
   * @param reviews The list of reviews.
   * @return The top N competitors.
   */
  public List<String> getTopNCompetitors(
      final int numerOfCompetitorsToReturn,
      final List<String> competitors,
      final List<String> reviews) {

    final Map<String, Integer> mapToCompetitorsToReviews =
        createCompetitorsMap(competitors, reviews);
    final Map<String, Integer> mapToCompetitorsToReviewsSorted =
        sortCompetitorMap(mapToCompetitorsToReviews);

    final List<String> topNCompetitors = new LinkedList<>();

    int limit =
        (numerOfCompetitorsToReturn < competitors.size())
            ? numerOfCompetitorsToReturn
            : competitors.size();

    for (final String competitor : mapToCompetitorsToReviewsSorted.keySet()) {
      if (limit <= 0) {
        break;
      }

      limit--;

      topNCompetitors.add(competitor);
    }

    return topNCompetitors;
  }

  /**
   * Create a map of competitors to reviews.
   *
   * @param competitors The list of competitors.
   * @param reviews The list of reviews.
   * @return The map of competitors to reviews.
   */
  private Map<String, Integer> createCompetitorsMap(
      final List<String> competitors, final List<String> reviews) {

    final Map<String, Integer> mapToCompetitorsToReviews = new LinkedHashMap<>();

    for (final String competitor : competitors) {
      mapToCompetitorsToReviews.put(competitor, 0);

      for (final String review : reviews) {
        if (review.indexOf(competitor) >= 0) {
          mapToCompetitorsToReviews.put(competitor, mapToCompetitorsToReviews.get(competitor) + 1);
        }
      }
    }

    return mapToCompetitorsToReviews;
  }

  /**
   * Sorts the map according the conditions provided for the problem.
   *
   * @param unsortedMap The unsorted map.
   * @return The sorted map.
   */
  private Map<String, Integer> sortCompetitorMap(final Map<String, Integer> unsortedMap) {
    final Comparator<Map.Entry<String, Integer>> mapComparator =
        new Comparator<Map.Entry<String, Integer>>() {

          /** Sorting in descending order. */
          @Override
          public int compare(final Entry<String, Integer> o1, final Entry<String, Integer> o2) {

            if (o1.getValue() == o2.getValue()) {
              // sort by names in ascending order
              return o1.getKey().compareTo(o2.getKey());
            }

            // sort review is descending order
            return o2.getValue().compareTo(o1.getValue());
          }
        };

    final List<Map.Entry<String, Integer>> mapList = new LinkedList<>(unsortedMap.entrySet());

    mapList.sort(mapComparator);

    final Map<String, Integer> sortedMap = new LinkedHashMap<>();
    for (final Map.Entry<String, Integer> entry : mapList) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap;
  }
}
