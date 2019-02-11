package com.example.atelier.model.Requests;

import javax.persistence.*;

@Entity(name = "Repair")
@Table(name = "repair")
public class Repair{

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="request")
    private Request request;

    private int masterid;
}