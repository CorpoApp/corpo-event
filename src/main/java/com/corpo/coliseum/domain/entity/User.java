package com.corpo.coliseum.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "corpo_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends PanacheEntityBase implements Serializable {

    private static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue
    public UUID id;
    @Column(unique = true)
    public String mail;
    public String name;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "corporation_users",
            joinColumns = { @JoinColumn(name = "corpo_user_id") },
            inverseJoinColumns = { @JoinColumn(name = "corporation_id") }
    )
    public Set<Corporation> corporationList;

    public static Optional<User> findByMail(String mail) {
        return Optional.of(find("mail", mail).firstResult());
    }
}
