package com.cipil.first.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Dinco-WORK on 23.06.2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Deployment")
public class Deployment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="component_id", nullable=false)
    private Component component;

    @Column(name="environment")
    private String environment;
//
    public Deployment(LocalDate date, Component component, String environment) {
        this.date = date;
        this.component = component;
        this.environment = environment;
    }
}
