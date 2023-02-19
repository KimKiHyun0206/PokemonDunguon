package com.spring.pokemondungeon.service;

import com.spring.pokemondungeon.dto.response.PokemonResponse;
import com.spring.pokemondungeon.entity.Pokemon;
import com.spring.pokemondungeon.exception.PokemonException;
import com.spring.pokemondungeon.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BattleService {
    private final Long userPokemon = 1L;
    private final PokemonRepository pokemonRepository;
    private final PokemonService pokemonService;
    private Long knockedDown = 0L;

    public Long getOpponentPokemonId() {
        return knockedDown + 2;
    }

    //공격
    @Transactional
    public PokemonResponse userAttack() {
        Pokemon user = pokemonRepository
                .findById(userPokemon)
                .orElseThrow(PokemonException::new);

        Pokemon opponent = pokemonRepository
                .findById(knockedDown + 2)
                .orElseThrow(PokemonException::new);

        return attack(user, opponent);
    }

    @Transactional
    public PokemonResponse opponentAttack() {
        Pokemon user = pokemonRepository
                .findById(userPokemon)
                .orElseThrow(PokemonException::new);

        Pokemon opponent = pokemonRepository
                .findById(knockedDown + 2)
                .orElseThrow(PokemonException::new);

        return attack(opponent, user);
    }

    @Transactional
    PokemonResponse attack(Pokemon attacker, Pokemon defender) {
        int damage = (int) attacker.getAttack();

        defender.attacked(damage);

        log.info("pokemon attack {}", damage);

        deletePokemon(defender);

        return PokemonResponse.from(defender);
    }

    private boolean checkPokemonHp(Pokemon pokemon) {
        return pokemon.getHp() > 0;
    }

    private void deletePokemon(Pokemon pokemon) {
        if (!checkPokemonHp(pokemon)) {
            pokemonService.delete(pokemon.getId());
            knockedDown++;
            log.info("pokemon hp 0 delete. {}", pokemon.getId());
        }
    }
}
