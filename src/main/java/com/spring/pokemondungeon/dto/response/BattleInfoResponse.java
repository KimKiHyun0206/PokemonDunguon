package com.spring.pokemondungeon.dto.response;

import com.spring.pokemondungeon.entity.Pokemon;
import lombok.Data;

@Data
public class BattleInfoResponse {
    private final int userPokemonHp;
    private final int opponentPokemonHp;

    public BattleInfoResponse(int userPokemonHp, int opponentPokemonHp) {
        this.userPokemonHp = userPokemonHp;
        this.opponentPokemonHp = opponentPokemonHp;
    }

    public static BattleInfoResponse from(Pokemon user, Pokemon opponent){
        return new BattleInfoResponse(
                user.getHp(),
                opponent.getHp()
        );
    }
}
