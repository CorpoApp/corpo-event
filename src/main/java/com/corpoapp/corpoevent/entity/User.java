package com.corpoapp.corpoevent.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "corpo_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends PanacheEntity {

    @Column(unique = true)
    public String mail;
    public String name;

}
