package com.corpo.coliseum.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "corpo_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends PanacheEntity {

    @Column(unique = true)
    public String mail;
    public String name;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "corporation_users",
            joinColumns = { @JoinColumn(name = "corpo_user_id") },
            inverseJoinColumns = { @JoinColumn(name = "corporation_id") }
    )
    public List<Corporation> corporationList;
}
