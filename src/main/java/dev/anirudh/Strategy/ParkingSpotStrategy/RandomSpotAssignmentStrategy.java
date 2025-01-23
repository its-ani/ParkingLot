package dev.anirudh.Strategy.ParkingSpotStrategy;

import dev.anirudh.Models.ParkingSpot;
import dev.anirudh.Models.Vehicle;

public class RandomSpotAssignmentStrategy implements ParkingSpotAssignnmetStrategy {
    @Override
    public ParkingSpot assignParkingSpot(Vehicle vehicle) {
        return new ParkingSpot();
    }
}
