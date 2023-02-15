package com.spring.pokemondungeon.service;

import com.spring.pokemondungeon.dto.request.PokemonRegisterRequest;
import com.spring.pokemondungeon.dto.response.PokemonResponse;
import com.spring.pokemondungeon.entity.Pokemon;
import com.spring.pokemondungeon.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    //삽입
    @Transactional
    public PokemonResponse register(PokemonRegisterRequest request){
        Pokemon pokemon = new Pokemon(
                request.getName(),
                request.getHp(),
                request.getAttack()
        );

        Pokemon savePokemon = pokemonRepository.save(pokemon);

        log.info("pokemon 등록했습니다. {}", pokemon.getId());

        return PokemonResponse.from(savePokemon);
    }


    //단건 조회
    @Transactional(readOnly = true)
    public PokemonResponse get(Long id){
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow();

        log.info("pokemon 조회했습니다 {}", pokemon.getId());
        return PokemonResponse.from(pokemon);
    }

    //페이징 조회
    @Transactional(readOnly = true)
    public Page<PokemonResponse> getAll(Pageable pageable){
        log.info("pokemon 전체 조회");

        return pokemonRepository.findAll(pageable)
                .map(PokemonResponse::from);
    }

    @Transactional(readOnly = true)
    public int getSizeOfPokemon(Pageable pageable){
        log.info("pokemon 전체 수량 조회");

        pokemonRepository.findAll(pageable).map(PokemonResponse::from).getTotalElements();
        return (int) pokemonRepository.findAll(pageable).map(PokemonResponse::from).getTotalElements();
    }
}