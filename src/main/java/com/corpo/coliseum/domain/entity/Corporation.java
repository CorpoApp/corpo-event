package com.corpo.coliseum.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "corporation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Corporation extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public UUID id;
    @Column(unique = true)
    public String name;
    public String sport;
    @ManyToMany
    @JoinTable(
            name = "corporation_users",
            joinColumns = @JoinColumn(name = "corporation_id"),
            inverseJoinColumns = @JoinColumn(name = "corpo_user_id")
    )
    public List<User> userList;
}

