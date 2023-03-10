package com.spring.pokemondungeon.dto.request.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PokemonRegisterRequest {
    private String name;
    private int hp;
    private float attack;
    private String skill;
}
