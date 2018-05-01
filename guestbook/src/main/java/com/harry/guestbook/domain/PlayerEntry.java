package com.harry.guestbook.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table (name = "players")
public class PlayerEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "player_id")
    public Integer id;
    @NotEmpty
    public String player;
    @NotEmpty
    public String position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
