package org.example.controllers;

import org.example.dtos.GenerateTicketRequestDto;
import org.example.dtos.GenerateTicketResponseDto;
import org.example.dtos.ResponseStatus;
import org.example.exceptions.GateNotFoundException;
import org.example.models.Ticket;
import org.example.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    //generate ticket API
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto) throws GateNotFoundException {

        Ticket  ticket = ticketService.generateTicket(
                requestDto.getGateId(),
                requestDto.getVehicleNumber(),
                requestDto.getUserName(),
                requestDto.getVehicleType(),
                requestDto.getParkingSpotAssignmentStrategyType()
        );

        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        responseDto.setTicket(ticket);
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);

        return responseDto;
    }

}
