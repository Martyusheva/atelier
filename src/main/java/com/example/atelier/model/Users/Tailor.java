package com.example.atelier.model.Users;

import javax.persistence.*;

@Entity(name = "Tailor")
@Table(name = "tailor")
public class Tailor {

    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user")
    private User user;

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public Tailor() {}


}