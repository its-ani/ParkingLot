package dev.anirudh.Strategy.ParkingSpotStrategy;

import dev.anirudh.Models.ParkingSpot;
import dev.anirudh.Models.Vehicle;

public interface ParkingSpotAssignnmetStrategy {
    ParkingSpot assignParkingSpot(Vehicle vehicle);
}
