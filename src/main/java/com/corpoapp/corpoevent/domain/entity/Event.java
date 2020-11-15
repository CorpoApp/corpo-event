package com.corpoapp.corpoevent.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "event")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event extends PanacheEntity implements Serializable {

    public String name;
    public String description;
    @Column(name = "user_slots")
    public Integer userSlots;
    @Column(name = "remaining_slots")
    public Integer remainingSlots;
    public BigDecimal interval;
    @Column(name = "start_date")
    public LocalDateTime startDate;
    public BigDecimal duration;

}
