package org.example.strategy;

import org.example.models.ParkingSpot;
import org.example.models.Vehicle;

public interface ParkingSpotAssignmentStrategy {
    public ParkingSpot assignParkingSpot(Vehicle vehicle);
}
