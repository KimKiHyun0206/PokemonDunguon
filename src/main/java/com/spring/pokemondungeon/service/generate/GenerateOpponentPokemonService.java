package com.spring.pokemondungeon.service.generate;

import com.spring.pokemondungeon.dto.request.pokemon.PokemonRegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class GenerateOpponentPokemonService {
    public PokemonRegisterRequest generate() {
        return new PokemonRegisterRequest(
                "RandomGeneratePokemon",
                (int) (Math.random() * 5) + 1,
                (int) (Math.random() * 5) + 1
        );
    }
}
