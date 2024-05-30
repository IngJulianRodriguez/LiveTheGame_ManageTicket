package com.livethegame.ManageTicket.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
public class PriceStages {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence_pricestages", allocationSize = 1)
    private long id;
    private String name;
    private long price;
    private LocalDate starts_at;
    private LocalDate finish_at;
    private boolean is_active;
    private LocalDateTime date_created;
    private LocalDateTime last_updated;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services service;
    private Long service_id_value;

    public PriceStages() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public LocalDate getStarts_at() {
        return starts_at;
    }

    public void setStarts_at(LocalDate starts_at) {
        this.starts_at = starts_at;
    }

    public LocalDate getFinish_at() {
        return finish_at;
    }

    public void setFinish_at(LocalDate finish_at) {
        this.finish_at = finish_at;
    }

    public boolean is_active() {
        return is_active;
    }

    public void setIs_active() {
        this.is_active = true;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public Long getService_id_value() {
        return service_id_value;
    }

    public void setService_id_value(Long service_id_value) {
        this.service_id_value = service_id_value;
    }
}
