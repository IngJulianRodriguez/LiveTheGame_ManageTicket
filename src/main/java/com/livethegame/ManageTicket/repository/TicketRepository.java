package com.livethegame.ManageTicket.repository;

import com.livethegame.ManageTicket.entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Tickets, Long> {
}
