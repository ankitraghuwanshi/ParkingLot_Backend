package org.example;

import org.example.controllers.TicketController;
import org.example.dtos.GenerateTicketRequestDto;
import org.example.exceptions.GateNotFoundException;
import org.example.models.Ticket;
import org.example.models.VehicleType;
import org.example.repositories.GateRepository;
import org.example.repositories.TicketRepository;
import org.example.repositories.VehicleRepository;
import org.example.services.TicketService;
import org.example.strategy.ParkingSpotAssignmentStrategyType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws GateNotFoundException {

        //Dto
        GenerateTicketRequestDto requestDto = new GenerateTicketRequestDto();
        requestDto.setGateId(123L);
        requestDto.setVehicleNumber("mp04zs1234");
        requestDto.setUserName("Ankit");
        requestDto.setVehicleType(VehicleType.SUV);
        requestDto.setParkingSpotAssignmentStrategyType(ParkingSpotAssignmentStrategyType.NEAREST);

        //repository
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository  vehicleRepository = new VehicleRepository();

        //service
        TicketService ticketService=new TicketService(
                gateRepository,
                vehicleRepository,
                ticketRepository
        );

        //controller
        TicketController ticketController = new TicketController(ticketService);

        Ticket ticket = ticketController.generateTicket(requestDto).getTicket();
    }
}
/*
so in parkingLot project (without completing) we understand that
we need Dependency Injection Framework like Spring Framework so that
it automatically make dependent object without us
as we seen above main class that
Ticket dependent on TicketController,
TicketController dependent on TicketService,
TicketService dependent on 3 Repository like gate,vehicle,ticket Repository
*/