package com.spring.pokemondungeon.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "skill")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Skill {
    @Id
    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "damage")
    private int damage;

    @Column(name = "upgrade")
    private int upgrade;

    public void upgrade(int damage){
        this.damage = damage;
    }
}