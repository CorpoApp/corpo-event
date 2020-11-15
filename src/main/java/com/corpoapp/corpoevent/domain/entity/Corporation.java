package com.corpoapp.corpoevent.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "corporation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Corporation extends PanacheEntity {

    @Column(unique = true)
    public String name;
    public String sport;
    @ManyToMany
    public List<User> userList;
}

