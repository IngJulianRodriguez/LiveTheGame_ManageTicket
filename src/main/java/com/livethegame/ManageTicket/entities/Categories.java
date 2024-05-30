package com.livethegame.ManageTicket.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence_categories", allocationSize = 1)
    private long id;
    private String alias;
    private String description;
    private int participants_max;
    private boolean is_active;
    private LocalDateTime date_created;
    private LocalDateTime last_updated;


    public Categories() {
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParticipants_max() {
        return participants_max;
    }

    public void setParticipants_max(int participants_max) {
        this.participants_max = participants_max;
    }

}
