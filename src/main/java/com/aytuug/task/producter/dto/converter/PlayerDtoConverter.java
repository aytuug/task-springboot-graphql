package com.aytuug.task.producter.dto.converter;

import com.aytuug.task.producter.dto.PlayerDto;
import com.aytuug.task.producter.entity.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerDtoConverter {
    public PlayerDto convert(Player player){
        PlayerDto playerDto = new PlayerDto();
        playerDto.setFirstName(player.getFirstName());
        playerDto.setLastName(player.getLastName());
        playerDto.setPosition(player.getPosition().getDescription());
        return playerDto;
    }
}
