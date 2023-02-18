package com.spring.pokemondungeon.controller;

import com.spring.pokemondungeon.common.dto.ResponseDto;
import com.spring.pokemondungeon.dto.response.KnockedDownResponse;
import com.spring.pokemondungeon.dto.response.PokemonResponse;
import com.spring.pokemondungeon.service.BattleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Pokemon Battle API"})
@RestController
@RequestMapping(value = "/api/v1/battle", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BattleController {
    private final BattleService battleService;

    @ApiOperation(value = "User Pokemon 공격")
    @PutMapping(value = "/attack/user")
    public ResponseEntity<?> userAttack(){
        PokemonResponse pokemonResponse = battleService.userAttack();

        return ResponseDto.ok(pokemonResponse);
    }

    @ApiOperation(value = "Opponent Pokemon 공격")
    @PutMapping(value = "/attack/opponent")
    public ResponseEntity<?> opponentAttack(){
        PokemonResponse pokemonResponse = battleService.opponentAttack();

        return ResponseDto.ok(pokemonResponse);
    }

    @ApiOperation(value = "쓰러뜨린 포켓몬 수")
    @RequestMapping(value = "/knocked-pokemon")
    public KnockedDownResponse knockedPokemon(){
        return new KnockedDownResponse(battleService.getOpponentPokemonId());
    }


}
