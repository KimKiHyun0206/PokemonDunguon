package com.spring.pokemondungeon.dto.response;

import com.spring.pokemondungeon.entity.Pokemon;
import lombok.Data;

@Data
public class PokemonResponse {
    private final Long id;
    private final String name;
    private final int hp;
    private final float attack;

    public static PokemonResponse from(Pokemon pokemon) {
        return new PokemonResponse(
                pokemon.getId(),
                pokemon.getName(),
                pokemon.getHp(),
                pokemon.getAttack()
        );
    }
}
