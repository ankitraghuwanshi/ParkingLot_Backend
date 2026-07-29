package org.example.repositories;

import org.example.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<Long, Vehicle> vehicleMap=new HashMap<>();
    private Long vehicleId;

    public Vehicle save(Vehicle vehicle) {
        return null;
    }

    public Optional<Vehicle> findById(Long vehicleId) {
        if(vehicleMap.containsKey(vehicleId)) {
            return Optional.of(vehicleMap.get(vehicleId));
        }else{
            return Optional.empty();
        }
    }

    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) {
        for(Vehicle vehicle:vehicleMap.values()){
            if(vehicle.getVehicleNumber().equals(vehicleNumber)){
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }
}
