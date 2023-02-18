package com.spring.pokemondungeon.service.validation;

import com.spring.pokemondungeon.dto.request.pokemon.PokemonRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PokemonValidationService {
    public boolean isPokemonIsValidate(PokemonRegisterRequest pokemon) {
        float values = pokemon.getAttack() + pokemon.getHp();

        return values <= 10;
    }
}
