package com.aytuug.task.producter.repository;


import com.aytuug.task.producter.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
