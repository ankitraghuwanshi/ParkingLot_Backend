package org.example.services;

import org.example.exceptions.GateNotFoundException;
import org.example.factory.ParkingSpotAssignmentStrategyFactory;
import org.example.models.*;
import org.example.repositories.GateRepository;
import org.example.repositories.TicketRepository;
import org.example.repositories.VehicleRepository;
import org.example.strategy.ParkingSpotAssignmentStrategy;
import org.example.strategy.ParkingSpotAssignmentStrategyType;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(Long gateId,
                                 String vehicleNumber,
                                 String userName,
                                 VehicleType vehicleType,
                                 ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType) throws GateNotFoundException {

        /*steps
        1.get gate object from DB (for gate we need gate repository)
        2.if gateId is invalid throw an exception
        3.check if vehicle is present in DB or not
        4.if yes good, else store vehicle object in DB
        5.assign the parking spot
        6.generate the ticket
        */

        //1.
        Optional<Gate> optionalGate = gateRepository.findById(gateId);
        //2.
        if(optionalGate.isEmpty()) {
            //if gate not found
            //throw exception invalid gateId
            throw new GateNotFoundException("Gate with id " + gateId + " not found");
        }
        Gate gate = optionalGate.get();

        //3.
        Optional<Vehicle> optionalVehicle=vehicleRepository.findByVehicleNumber(vehicleNumber);
        //4.
        Vehicle vehicle = null;
        if(optionalVehicle.isEmpty()) {
            //if vehicle not found
            //create the vehicle object and save it in DB
            vehicle=new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnername(userName);

            vehicle=vehicleRepository.save(vehicle);
        }else{
            vehicle=optionalVehicle.get();
        }

        //5.
        ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy =
                ParkingSpotAssignmentStrategyFactory
                        .getParkingSpotAssignmentStrategy(parkingSpotAssignmentStrategyType);

        //prevent null pointer exception for parkingSpot
        ParkingSpot parkingSpot=null;

        if(parkingSpotAssignmentStrategy != null) {
            parkingSpot=parkingSpotAssignmentStrategy.assignParkingSpot(vehicle);
        }

        Ticket ticket=new Ticket();
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryTime(new Date());

        //save the ticket to DB
        return ticketRepository.save(ticket);
    }
}
