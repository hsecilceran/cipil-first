package com.cipil.first.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Dinco-WORK on 20.06.2017.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="value")
    private String value;

    @ManyToOne
    @JoinColumn(name="profile_id", nullable=false)
    private Profile profile;

    public Address(String value, Profile profile) {
        this.value = value;
        this.profile = profile;
    }
}
