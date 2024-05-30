package com.livethegame.ManageTicket.Utils;

import com.livethegame.ManageTicket.dto.TicketRequest;
import com.livethegame.ManageTicket.entities.*;

public  class Mapper {
    public static Tickets TicketRequestToTicket(TicketRequest source, Users user, Long idServicio, Services service, TicketsStages ticketsStages, long stagePrice){
        Tickets ticket = new Tickets();
        ticket.setUser(user);
        ticket.setService_id_value(idServicio);
        ticket.setService(service);
        ticket.setTicket_stage(ticketsStages);
        ticket.setPrice_ticket(stagePrice);
        return ticket;
    };
}
