package com.livethegame.ManageTicket.entities;

import java.time.*;
import javax.persistence.*;

@Entity
public class Tournaments {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence_tournaments", allocationSize = 1)
    private long id;
    private LocalDate start_date;
    private String start_time;
    private double commission;
    private boolean is_active;
    private LocalDateTime date_created;
    private LocalDateTime last_updated;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;
    @ManyToOne
    @JoinColumn(name = "tournament_type_id")
    private TournamentTypes tournament_type;

    public Tournaments() {
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

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public Categories getCategory() {
        return categories;
    }

    public void setCategory(Categories categories) {
        this.categories = categories;
    }

    public TournamentTypes getTournament_type() {
        return tournament_type;
    }

    public void setTournament_type(TournamentTypes tournament_type) {
        this.tournament_type = tournament_type;
    }

    public boolean is_active() {
        return is_active;
    }

    public void setIs_active() {
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

    public void setLast_updated() {
        this.last_updated = this.getDate_created();
    }


}
