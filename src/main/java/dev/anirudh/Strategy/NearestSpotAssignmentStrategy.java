package dev.anirudh.Strategy;

import dev.anirudh.Models.ParkingSpot;
import dev.anirudh.Models.Vehicle;

public class NearestSpotAssignmentStrategy implements ParkingSpotAssignnmetStrategy {
    @Override
    public ParkingSpot assignParkingSpot(Vehicle vehicle) {
        return new ParkingSpot();
    }
}
