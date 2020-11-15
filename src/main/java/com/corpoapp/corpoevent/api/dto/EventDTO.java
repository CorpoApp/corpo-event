package com.corpoapp.corpoevent.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EventDTO {

    private String name;
    private String description;
    private Integer userSlots;
    private Integer remainingSlots;
    private BigDecimal interval;
    private LocalDateTime startDate;
    private BigDecimal duration;

}
