package com.aytuug.task.producter.requests;

import com.aytuug.task.producter.entity.Position;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PlayerRequest {

    private String firstName;
    private String lastName;
    private Position position;

}
