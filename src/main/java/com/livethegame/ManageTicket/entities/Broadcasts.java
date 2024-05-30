package com.livethegame.ManageTicket.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
public class Broadcasts {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence_broadcasts", allocationSize = 1)
    private long id;
    private double viewers_max;
    private boolean is_active;
    private LocalDateTime date_created;
    private LocalDateTime last_updated;
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournaments tournament;
    @ManyToOne
    @JoinColumn(name = "broadcast_type_id")
    private BroadcastTypes broadcastType;
    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platforms platform;


    public Broadcasts() {
        this.setDate_created();
        this.setLast_updated();
        this.setIs_active();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getViewers_max() {
        return viewers_max;
    }

    public void setViewers_max(double viewers_max) {
        this.viewers_max = viewers_max;
    }

    public boolean is_active() {
        return is_active;
    }

    private void setIs_active() {
        this.is_active = true;
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

    private void setLast_updated() {
        this.last_updated = this.getDate_created();
    }

    public Tournaments getTournament() {
        return tournament;
    }

    public void setTournament(Tournaments tournament) {
        this.tournament = tournament;
    }

    public BroadcastTypes getBroadcastType() {
        return broadcastType;
    }

    public void setBroadcastType(BroadcastTypes broadcastType) {
        this.broadcastType = broadcastType;
    }

    public Platforms getPlatform() {
        return platform;
    }

    public void setPlatform(Platforms platform) {
        this.platform = platform;
    }
}
