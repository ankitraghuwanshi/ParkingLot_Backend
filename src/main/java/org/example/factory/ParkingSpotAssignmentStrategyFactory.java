package org.example.factory;

import org.example.strategy.*;

public class ParkingSpotAssignmentStrategyFactory {
    public static ParkingSpotAssignmentStrategy getParkingSpotAssignmentStrategy(
            ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType) {

        if(parkingSpotAssignmentStrategyType.equals(ParkingSpotAssignmentStrategyType.RANDOM)){
            return new RandomParkingSpotAssignmentStrategy();
        } else if (parkingSpotAssignmentStrategyType.equals(ParkingSpotAssignmentStrategyType.NEAREST)) {
            return new NearestParkingSpotAssignmentStrategy();
        }else if(parkingSpotAssignmentStrategyType.equals(ParkingSpotAssignmentStrategyType.CHEAPEST)){
            return new CheapestParkingSpotAssignmentStrategy();
        }
        return null;
    }
}
