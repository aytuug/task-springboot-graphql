package com.aytuug.task.producter.controller;

import com.aytuug.task.producter.dto.PlayerDto;
import com.aytuug.task.producter.entity.Player;
import com.aytuug.task.producter.entity.Position;
import com.aytuug.task.producter.requests.PlayerRequest;
import com.aytuug.task.producter.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @QueryMapping
    public List<PlayerDto> findAllPlayers(){
        System.out.println(playerService.findAllPlayers().size());
        return playerService.findAllPlayers();

    }

    @MutationMapping
    public Player savePlayer(@Argument String firstName, @Argument String lastName, @Argument Position position){
        return playerService.savePlayer(firstName, lastName, position);
    }

    @MutationMapping
    public void delete(@Argument Long id){
        playerService.deletePlayerById(id);
    }


}
