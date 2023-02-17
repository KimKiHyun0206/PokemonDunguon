package com.spring.pokemondungeon.service;

import org.springframework.stereotype.Service;

@Service
public class ProcessService {
    private Long knockedDown = 0L;

    public Long getOpponentPokemonId() {
        return knockedDown + 2;
    }

    public void opponentPokemonKnockedDown(){
        knockedDown++;
    }
}
