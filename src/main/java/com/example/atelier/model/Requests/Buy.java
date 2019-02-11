package com.example.atelier.model.Requests;

import javax.persistence.*;

@Entity(name = "Buy")
@Table(name = "buy")
public class Buy {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="request")
    public Request request;

    public Buy(Request request) {
        this.request = request;
    }

    public Buy() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
