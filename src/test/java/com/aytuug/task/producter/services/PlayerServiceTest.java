package com.aytuug.task.producter.services;


import com.aytuug.task.producter.dto.PlayerDto;
import com.aytuug.task.producter.dto.converter.PlayerDtoConverter;
import com.aytuug.task.producter.entity.Player;
import com.aytuug.task.producter.entity.Position;
import com.aytuug.task.producter.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerServiceTest {

    private PlayerService playerService;
    private PlayerRepository playerRepository;
    private Player player;
    private PlayerDto playerDto;
    private PlayerDtoConverter playerDtoConverter;

    @BeforeEach
    public void setUp() throws Exception{
        playerRepository = Mockito.mock(PlayerRepository.class);
        playerService = Mockito.mock(PlayerService.class);
        player = Mockito.mock(Player.class);
        playerDto = Mockito.mock(PlayerDto.class);
        playerDtoConverter = Mockito.mock(PlayerDtoConverter.class);

        playerService = new PlayerService(playerRepository,playerDtoConverter);
    }

    @Test
    public void whenCreatePlayerCalledWithValidRequest_isShouldReturnValidPlayer(){
        Player player = new Player();
        String firstName = "TestFirstName";
        player.setFirstName(firstName);
        String lastName = "TestLastName";
        player.setLastName(lastName);
        Position position = Position.C;
        player.setPosition(position);

        Mockito.when(playerRepository.save(ArgumentMatchers.any(Player.class))).thenReturn(player);
        Player result = playerService.savePlayer(firstName, lastName, position);

        assertEquals(result.getFirstName(), player.getFirstName());

     }

     @Test
    public void whenGetPlayerCalledWithValidRequest_isShouldReturnList(){
        Mockito.when(playerRepository.findAll()).thenReturn(Stream
                .of(new Player(334L,"AytugTest","AytugTest",Position.SF), new Player(443L, "AytugSecondTest", "AytugSecondeTes", Position.C))
                .collect(Collectors.toList()));
        assertEquals(2,playerService.findAllPlayers().size());
     }

    @Test
    public void whenDeletePlayerCalledWithValidId_isShouldReturnVoid(){
        Player testPlayer = new Player(342L, "Aytugtest", "Aytugtest", Position.PF);
        playerService.deletePlayerById(testPlayer.getId());
        Mockito.verify(playerRepository, Mockito.times(1)).deleteById(testPlayer.getId());
    }


}
