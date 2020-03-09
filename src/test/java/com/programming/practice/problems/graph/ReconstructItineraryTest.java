package com.programming.practice.problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ReconstructItinerary}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ReconstructItineraryTest {

  private final ReconstructItinerary obj = new ReconstructItinerary();

  /**
   * Converts tickets represented as 2D array to list.
   *
   * @param tickets The tickets represented in 2D array.
   * @return The list representation of the tickets.
   */
  private List<List<String>> convert2DArrayToList(final String[][] tickets) {
    final List<List<String>> ticketList = new ArrayList<>();

    for (final String[] ticket : tickets) {
      ticketList.add(Arrays.asList(ticket[0], ticket[1]));
    }

    return ticketList;
  }

  @Test
  public void testScenario1() {
    final List<List<String>> tickets =
        convert2DArrayToList(
            new String[][] {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}});

    final List<String> expectedItinerary = Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC");
    Assert.assertEquals(expectedItinerary, obj.findItinerary(tickets));
  }

  @Test
  public void testScenario2() {
    final List<List<String>> tickets =
        convert2DArrayToList(
            new String[][] {
              {"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}
            });

    final List<String> expectedItinerary = Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
    Assert.assertEquals(expectedItinerary, obj.findItinerary(tickets));
  }

  @Test
  public void testScenario3() {
    final List<List<String>> tickets =
        convert2DArrayToList(new String[][] {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}});

    final List<String> expectedItinerary = Arrays.asList("JFK", "NRT", "JFK", "KUL");
    Assert.assertEquals(expectedItinerary, obj.findItinerary(tickets));
  }
}
