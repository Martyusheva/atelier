package com.example.atelier.model.Users;

import javax.persistence.*;

@Entity(name = "Administrator")
@Table(name = "administrator")
public class Administrator{

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user")
    private User user;

    public Administrator() {}

    public Administrator(User user) {
        this.user = user;
    }

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
}
