package dev.anirudh.Repository;

import dev.anirudh.Models.Ticket;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Long, Ticket> ticketMap = new HashMap<>();
    private Long ticketId = 0L;

    public Ticket save(Ticket ticket) {
        ticketId += 1;
        ticket.setId(ticketId);
        ticketMap.put(ticketId, ticket);

        return ticket;
    }
}
