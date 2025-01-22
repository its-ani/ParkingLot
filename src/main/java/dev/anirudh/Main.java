package dev.anirudh;

import dev.anirudh.Controllers.TicketController;
import dev.anirudh.DTOs.GenerateTicketRequestDto;
import dev.anirudh.Models.ParkingSpotAssignmentStrategyType;
import dev.anirudh.Models.VehicleType;
import dev.anirudh.Repository.GateRepository;
import dev.anirudh.Repository.TicketRepository;
import dev.anirudh.Repository.VehicleRepository;
import dev.anirudh.Service.TicketService;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        GenerateTicketRequestDto generateTicketRequestDto = new GenerateTicketRequestDto();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, ticketRepository);
        TicketController ticketController = new TicketController(ticketService);

        generateTicketRequestDto.setGateId(1L);
        generateTicketRequestDto.setOwnerName("Anirudh");
        generateTicketRequestDto.setParkingSpotassignmentStrategyType(ParkingSpotAssignmentStrategyType.RANDOM);
        generateTicketRequestDto.setVehicleNumber("DL 8S BP 5650");
        generateTicketRequestDto.setVehicleType(VehicleType.TWO_WHEELER);

//        ticketController.generateTicket(generateTicketRequestDto);
        System.out.println("Your Ticket is created " + ticketController.generateTicket(generateTicketRequestDto));

    }
}