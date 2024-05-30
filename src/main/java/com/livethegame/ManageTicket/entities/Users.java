package com.livethegame.ManageTicket.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    private long id;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private int phone;

    private LocalDate birthdate;
    private int identification_number;
    private String identification_type;
    private String country;
    private String currency;
    private int free_tournaments_created;
    private int free_views_tournaments_created;
    private boolean is_confirmed;
    private boolean is_active;
    private LocalDateTime date_created;
    private LocalDateTime last_updated;


    public Users() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getIdentification_number() {
        return identification_number;
    }

    public void setIdentification_number(int identification_number) {
        this.identification_number = identification_number;
    }

    public String getIdentification_type() {
        return identification_type;
    }

    public void setIdentification_type(String identification_type) {
        this.identification_type = identification_type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getFree_tournaments_created() {
        return free_tournaments_created;
    }

    public void setFree_tournaments_created() {
        this.free_tournaments_created = free_tournaments_created+1;
    }

    public int getFree_views_tournaments_created() {
        return free_views_tournaments_created;
    }

    public void setFree_views_tournaments_created() {
        this.free_views_tournaments_created = free_views_tournaments_created+1;
    }

    public boolean is_confirmed() {
        return is_confirmed;
    }

    public void setIs_confirmed() {
        this.is_confirmed = true;
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

    public void setDate_created() {
        this.date_created = LocalDateTime.now();;
    }

    public LocalDateTime getLast_updated() {
        return last_updated;
    }

    public void setLast_updated() {
        this.last_updated = LocalDateTime.now();;
    }

    public boolean verifyPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, this.password);
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }


}
