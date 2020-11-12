package com.corpoapp.corpoevent.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "corporation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Corporation extends PanacheEntity {

    @Column(unique = true)
    public String name;
    public String sport;
}

