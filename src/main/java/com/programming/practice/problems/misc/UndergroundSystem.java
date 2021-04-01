package com.programming.practice.problems.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement the UndergroundSystem class:
 *
 * <ul>
 *   <li>void checkIn(int id, string stationName, int t)
 *       <ul>
 *         <li>A customer with a card id equal to id, gets in the station stationName at time t.
 *         <li>A customer can only be checked into one place at a time.
 *       </ul>
 *   <li>void checkOut(int id, string stationName, int t)
 *       <ul>
 *         <li>A customer with a card id equal to id, gets out from the station stationName at time
 *             t.
 *       </ul>
 *   <li>double getAverageTime(string startStation, string endStation)
 *       <ul>
 *         <li>Returns the average time to travel between the startStation and the endStation.
 *         <li>The average time is computed from all the previous traveling from startStation to
 *             endStation that happened directly.
 *         <li>Call to getAverageTime is always valid.
 *       </ul>
 * </ul>
 *
 * You can assume all calls to checkIn and checkOut methods are consistent. If a customer gets in at
 * time t1 at some station, they get out at time t2 with t2 > t1. All events happen in chronological
 * order.
 *
 * <pre>
 * Example 1:
 *
 * Input
 * ["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
 * [[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
 *
 * Output
 * [null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
 *
 * Explanation
 * UndergroundSystem undergroundSystem = new UndergroundSystem();
 * undergroundSystem.checkIn(45, "Leyton", 3);
 * undergroundSystem.checkIn(32, "Paradise", 8);
 * undergroundSystem.checkIn(27, "Leyton", 10);
 * undergroundSystem.checkOut(45, "Waterloo", 15);
 * undergroundSystem.checkOut(27, "Waterloo", 20);
 * undergroundSystem.checkOut(32, "Cambridge", 22);
 * undergroundSystem.getAverageTime("Paradise", "Cambridge");       // return 14.00000. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.00000. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.00000
 * undergroundSystem.checkIn(10, "Leyton", 24);
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.00000
 * undergroundSystem.checkOut(10, "Waterloo", 38);
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 12.00000
 *
 * Example 2:
 *
 * Input
 * ["UndergroundSystem","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime"]
 * [[],[10,"Leyton",3],[10,"Paradise",8],["Leyton","Paradise"],[5,"Leyton",10],[5,"Paradise",16],["Leyton","Paradise"],[2,"Leyton",21],[2,"Paradise",30],["Leyton","Paradise"]]
 *
 * Output
 * [null,null,null,5.00000,null,null,5.50000,null,null,6.66667]
 *
 * Explanation
 * UndergroundSystem undergroundSystem = new UndergroundSystem();
 * undergroundSystem.checkIn(10, "Leyton", 3);
 * undergroundSystem.checkOut(10, "Paradise", 8);
 * undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.00000
 * undergroundSystem.checkIn(5, "Leyton", 10);
 * undergroundSystem.checkOut(5, "Paradise", 16);
 * undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.50000
 * undergroundSystem.checkIn(2, "Leyton", 21);
 * undergroundSystem.checkOut(2, "Paradise", 30);
 * undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 6.66667
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2021.
 * @see <a href = "https://leetcode.com/problems/design-underground-system/">Design Underground
 *     System</a>
 */
public final class UndergroundSystem {

  /** Class to represent a trip statistics. */
  private class TripStats {
    public int totalTripTime;
    public int totalTrips;

    public TripStats(final int totalTripTime, final int totalTrips) {
      this.totalTripTime = totalTripTime;
      this.totalTrips = totalTrips;
    }

    @Override
    public String toString() {
      return "totalTripTime: " + totalTripTime + " | totalTrips: " + totalTrips;
    }
  }

  /** Class to represent the checkin information for each station. */
  private class StationCheckin {
    public final String station;
    public final int timestamp;

    public StationCheckin(final String station, final int timestamp) {
      this.station = station;
      this.timestamp = timestamp;
    }

    @Override
    public String toString() {
      return "station: " + station + " | timestamp: " + timestamp;
    }
  }

  /** Map to store the station check-in information for each customer. */
  private final Map<Integer, StationCheckin> stationCheckinMapKeyedByCustomerId;

  /**
   * Map to store the trip statistics for a journey (startStation->endStation). The key is the
   * string representation of the start-end station.
   */
  private final Map<String, TripStats> tripStatsMapKeyedBySourceDestString;

  /** Public constructor for {@link UndergroundSystem} */
  public UndergroundSystem() {
    stationCheckinMapKeyedByCustomerId = new HashMap<>();
    tripStatsMapKeyedBySourceDestString = new HashMap<>();
  }

  /**
   * Checks in a customer.
   *
   * @param id The ID of the customer.
   * @param stationName The station name.
   * @param t The time-stamp.
   */
  public void checkIn(int id, String stationName, int t) {
    stationCheckinMapKeyedByCustomerId.put(id, new StationCheckin(stationName, t));
  }

  /**
   * Checks-out a customer.
   *
   * @param id The customer ID.
   * @param stationName The station name.
   * @param t The time-stamp.
   */
  public void checkOut(int id, String stationName, int t) {
    final StationCheckin stationCheckinInforForCustomer =
        stationCheckinMapKeyedByCustomerId.get(id);
    final String sourceStation = stationCheckinInforForCustomer.station;
    final int timestamp = stationCheckinInforForCustomer.timestamp;

    final String sourceDestString = createSourceDestinationString(sourceStation, stationName);

    final TripStats existingTripStats =
        tripStatsMapKeyedBySourceDestString.getOrDefault(sourceDestString, new TripStats(0, 0));
    existingTripStats.totalTripTime += (t - timestamp);
    existingTripStats.totalTrips++;

    tripStatsMapKeyedBySourceDestString.put(sourceDestString, existingTripStats);

    stationCheckinMapKeyedByCustomerId.remove(id);
  }

  /**
   * Calculates the average time for a journey.
   *
   * @param startStation The start station.
   * @param endStation The end station.
   * @return The average time for the journey.
   */
  public double getAverageTime(String startStation, String endStation) {
    System.out.println(tripStatsMapKeyedBySourceDestString);
    final String sourceDestString = createSourceDestinationString(startStation, endStation);
    final TripStats tripStats = tripStatsMapKeyedBySourceDestString.get(sourceDestString);

    return tripStats.totalTripTime / (double) tripStats.totalTrips;
  }

  /**
   * Creates a startDestination->endDestination string for the journey.
   *
   * @param startStation The start station.
   * @param endStation The end station.
   * @return The string representation of the journey.
   */
  private static String createSourceDestinationString(
      final String startStation, final String endStation) {
    return startStation + "->" + endStation;
  }
}
