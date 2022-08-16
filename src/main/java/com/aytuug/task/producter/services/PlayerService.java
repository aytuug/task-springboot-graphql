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
import java.util.Optional;

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

        //basketball team has maximum capacity during. => 5
        if (playerRepository.findAll().size() < 5){
            System.out.println(playerRepository.findAll().size());
            playerRepository.save(player);
        }else{
            throw new RuntimeException("basketball team has maximum capacity during. => 5");
        }

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
