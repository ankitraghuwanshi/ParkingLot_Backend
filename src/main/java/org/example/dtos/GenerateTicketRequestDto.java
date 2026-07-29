package org.example.dtos;

import org.example.models.VehicleType;
import org.example.strategy.ParkingSpotAssignmentStrategy;
import org.example.strategy.ParkingSpotAssignmentStrategyType;

public class GenerateTicketRequestDto {
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Long gateId; //frontend and backend talk with id (not with object)
    private String userName;
    private ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType;


    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ParkingSpotAssignmentStrategyType getParkingSpotAssignmentStrategyType() {
        return parkingSpotAssignmentStrategyType;
    }

    public void setParkingSpotAssignmentStrategyType(ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType) {
        this.parkingSpotAssignmentStrategyType = parkingSpotAssignmentStrategyType;
    }
}
