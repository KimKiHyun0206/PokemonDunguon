package com.spring.pokemondungeon.dto.request;

import lombok.Data;

@Data
public class PokemonUpdateRequest {
    private String name;
    private int hp;
    private int attack;
}
