package com.example.atelier.model.Requests;


import javax.persistence.*;

@Entity(name = "Tailoring")
@Table(name = "tailoring")
public class Tailoring {


    public int getId() {
        return id;
    }

    @Id
    @GeneratedValue
    private int id;

    public int getTailorid() {
        return tailorid;
    }

    private int tailorid;

    public Tailoring(int tailorid, Request request) {
        this.tailorid = tailorid;
        this.request = request;
    }

    public Tailoring() {
    }

    public void setTailorid(int tailorid) {
        this.tailorid = tailorid;
    }

    public Request getRequest() {
        return request;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="request")
    private Request request;

}
