package dev.anirudh.Service;

import dev.anirudh.ExceptionHandler.Exceptions;
import dev.anirudh.Factory.ParkingSpotAssignmentFactory;
import dev.anirudh.Models.*;
import dev.anirudh.Repository.GateRepository;
import dev.anirudh.Repository.TicketRepository;
import dev.anirudh.Repository.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
    }


    public Ticket genereateTicket(String vehicleNumber, String ownerName, Long gateId, VehicleType vehicleType, ParkingSpotAssignmentStrategyType strategyType){

        Optional<Gate> optionalGate = gateRepository.findById(gateId);
        if(optionalGate.isEmpty()){
            throw new Exceptions("Gate not found");
        }

        Gate gate = optionalGate.get();

        Optional<Vehicle> optionalVehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle vehicle = null;
        if(optionalVehicle.isEmpty()){
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            vehicle.setVehicleType(vehicleType);

            vehicle = vehicleRepository.save(vehicle);
        }
        else{
            vehicle = optionalVehicle.get();
        }

        ParkingSpot parkingSpot = ParkingSpotAssignmentFactory
                .getParkingSpotAssignnmetStrategy(strategyType)
                .assignParkingSpot(vehicle);

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setGate(gate);
        ticket.setParkingSpot(parkingSpot);
        ticket.setVehicle(vehicle);
        ticket.setCreatedAt(new Date());
        ticket.setLastModifiedAt(ticket.getCreatedAt());

        ticket = ticketRepository.save(ticket);

        return ticket;
    }
}
