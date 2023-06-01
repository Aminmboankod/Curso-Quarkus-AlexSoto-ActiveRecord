package edu.craptocraft.repository;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "developer")
public class Developer extends PanacheEntity {

    @Column(unique = true)
    public String name;

    @Column
    public Integer age;

}
