package com.livethegame.ManageTicket.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
public class Tickets {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence_tickets", allocationSize = 1)
    private long id;
    private double price_ticket;
    private LocalDateTime date_created;
    private LocalDateTime last_updated;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services service;
    private Long service_id_value;
    @ManyToOne
    @JoinColumn(name = "ticket_stage_id")
    private TicketsStages ticket_stage;

    public Tickets() {
        this.setDate_created();
        this.setLast_updated();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice_ticket() {
        return price_ticket;
    }

    public void setPrice_ticket(double price_ticket) {
        this.price_ticket = price_ticket;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Long getService_id_value() {
        return service_id_value;
    }

    public void setService_id_value(Long service_id_value) {
        this.service_id_value = service_id_value;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public TicketsStages getTicket_stage() {
        return ticket_stage;
    }

    public void setTicket_stage(TicketsStages ticket_stage) {
        this.ticket_stage = ticket_stage;
    }

    public LocalDateTime getDate_created() {
        return date_created;
    }

    private void setDate_created() {
        ZoneId easternTime = ZoneId.of("America/Bogota");
        this.date_created = LocalDateTime.now(easternTime);;
    }

    public LocalDateTime getLast_updated() {
        return last_updated;
    }

    public void setLast_updated() {
        ZoneId easternTime = ZoneId.of("America/Bogota");
        this.date_created = LocalDateTime.now(easternTime);
    }


}
