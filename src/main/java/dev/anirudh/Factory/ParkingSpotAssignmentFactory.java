package dev.anirudh.Factory;

import dev.anirudh.Models.ParkingSpotAssignmentStrategyType;
import dev.anirudh.Strategy.ParkingSpotStrategy.NearestSpotAssignmentStrategy;
import dev.anirudh.Strategy.ParkingSpotStrategy.ParkingSpotAssignnmetStrategy;
import dev.anirudh.Strategy.ParkingSpotStrategy.RandomSpotAssignmentStrategy;

public class ParkingSpotAssignmentFactory {
    public static ParkingSpotAssignnmetStrategy getParkingSpotAssignnmetStrategy(
        ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType){

        if (parkingSpotAssignmentStrategyType.equals(ParkingSpotAssignmentStrategyType.RANDOM)){
            return new NearestSpotAssignmentStrategy();
        }
        else if (parkingSpotAssignmentStrategyType.equals(ParkingSpotAssignmentStrategyType.NEAREST)) {
            return new RandomSpotAssignmentStrategy();
        }

        return new RandomSpotAssignmentStrategy();
    }
}
