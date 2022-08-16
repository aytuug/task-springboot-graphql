package com.aytuug.task.producter.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Position {
    PG("Point guard"),
    SG("Shooting guard"),
    SF("Small forward"),
    PF("Power forward"),
    C("Center");

    private String description;
    Position(String description){
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }


}
