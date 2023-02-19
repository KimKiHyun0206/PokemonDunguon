package com.spring.pokemondungeon.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "pokemon")
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

    @Column(name = "skill")
    private String skill;

    public Pokemon(String name, int hp, float attack,String skill) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.skill = skill;
    }

    public void updateHpAndAttack(int hp, float attack){
        this.attack = attack;
        this.hp = hp;
    }

    public void attacked(int damage){
        this.hp -= damage;
    }
}
