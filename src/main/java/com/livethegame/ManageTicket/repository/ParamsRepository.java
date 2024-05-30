package com.livethegame.ManageTicket.repository;

import com.livethegame.ManageTicket.entities.Params;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParamsRepository extends JpaRepository<Params, Long> {
    Optional<Params> findByName(String name);
}
