package com.spring.pokemondungeon.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "poke")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pokemon {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "hp")
    private int hp;

    @Column(name="attack")
    private float attack;

    public Pokemon(String name, int hp, float attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public void update(int hp, float attack){
        this.attack = attack;
        this.hp = hp;
    }
}
