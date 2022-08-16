package com.aytuug.task.producter.services;


import com.aytuug.task.producter.dto.PlayerDto;
import com.aytuug.task.producter.dto.converter.PlayerDtoConverter;
import com.aytuug.task.producter.entity.Player;
import com.aytuug.task.producter.entity.Position;
import com.aytuug.task.producter.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerDtoConverter playerDtoConverter;

    public Player savePlayer(String firstName, String lastName, Position position){
        Player player = new Player();
        player.setFirstName(firstName);
        player.setLastName(lastName);
        player.setPosition(position);
        playerRepository.save(player);
        return player;
    }

    public void deletePlayerById(Long id){
        playerRepository.deleteById(id);
        ResponseEntity.ok().build();
    }

    public List<PlayerDto> findAllPlayers(){
        List<Player> playerList = playerRepository.findAll();
        List<PlayerDto> playerDtoList = new ArrayList<>();
        for (Player player : playerList){
            playerDtoList.add(playerDtoConverter.convert(player));
        }
        return playerDtoList;
    }

}
