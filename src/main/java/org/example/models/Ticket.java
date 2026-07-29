package org.example.models;

import java.time.LocalDateTime;
import java.util.Date;

public class Ticket extends BaseModel{
    private String TicketNumber;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;
    private TicketStatus ticketStatus;
    private Operator Operator;
    private Gate Gate;


    public String getTicketNumber() {
        return TicketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        TicketNumber = ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Operator getOperator() {
        return Operator;
    }

    public void setOperator(Operator operator) {
        Operator = operator;
    }

    public Gate getGate() {
        return Gate;
    }

    public void setGate(Gate gate) {
        Gate = gate;
    }
}
