package dev.anirudh.Controllers;

import dev.anirudh.DTOs.GenerateTicketRequestDto;
import dev.anirudh.DTOs.GenerateTicketResponseDto;
import dev.anirudh.DTOs.ResponseStatus;
import dev.anirudh.Models.ParkingSpotAssignmentStrategyType;
import dev.anirudh.Models.Ticket;
import dev.anirudh.Models.VehicleType;
import dev.anirudh.Service.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto){

        String vehicleNumber = generateTicketRequestDto.getVehicleNumber();
        Long gateId = generateTicketRequestDto.getGateId();
        String ownerName = generateTicketRequestDto.getOwnerName();
        VehicleType vehicleType = generateTicketRequestDto.getVehicleType();
        ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType = generateTicketRequestDto.getParkingSpotassignmentStrategyType();

        GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
        try{
            Ticket ticket = ticketService.genereateTicket(
                    vehicleNumber,
                    ownerName,
                    gateId,
                    vehicleType,
                    parkingSpotAssignmentStrategyType
            );

            generateTicketResponseDto.setTicket(ticket);
            generateTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e){
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILED);
        }

        return generateTicketResponseDto;
    }
}
