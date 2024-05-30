package com.livethegame.ManageTicket.repository;

import com.livethegame.ManageTicket.entities.Broadcasts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BroadcastsRepository extends JpaRepository<Broadcasts, Long> {
    List<Broadcasts> findByTournamentId(Long id);
}
