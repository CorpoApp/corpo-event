package com.corpoapp.corpoevent.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisteredDTO {

    private EventDTO event;
    private UserDTO user;
    private LocalDateTime date;
}