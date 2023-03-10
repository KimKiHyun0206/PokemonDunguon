package com.spring.pokemondungeon.controller;

import com.spring.pokemondungeon.common.dto.PageDto;
import com.spring.pokemondungeon.common.dto.ResponseDto;
import com.spring.pokemondungeon.dto.request.pokemon.PokemonRegisterRequest;
import com.spring.pokemondungeon.dto.request.pokemon.PokemonUpdateRequest;
import com.spring.pokemondungeon.service.generate.GenerateOpponentPokemonService;
import com.spring.pokemondungeon.service.PokemonService;
import com.spring.pokemondungeon.service.validation.PokemonValidationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(tags = {"Pokemon Default API"})
@RestController
@RequestMapping(value = "/api/v1/default", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;
    private final PokemonValidationService pokemonValidationService;

    private final GenerateOpponentPokemonService generateOpponentPokemonService;


    @ApiOperation(value = "Pokemon 등록하기")
    @PostMapping(value = "/register/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> startGame(@RequestBody PokemonRegisterRequest request, Pageable pageable) {

        if (pokemonService.getSizeOfPokemon(pageable) > 0) {
            return ResponseDto.noContent();
        }

        if (pokemonValidationService.isPokemonIsValidate(request)) {
            var response = pokemonService.register(request);
            return ResponseDto.created(response);
        }

        return ResponseDto.noContent();
    }

    @ApiOperation(value = "Opponent Pokemon 등록하기")
    @PostMapping(value = "/register/opponent")
    public ResponseEntity<?> registerOpponentPokemon() {

        PokemonRegisterRequest request = generateOpponentPokemonService.generate();
        pokemonService.register(request);

        return ResponseDto.created(request);
    }

    @ApiOperation(value = "Pokemon 조회하기")
    @GetMapping("/search/single/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        var response = pokemonService.get(id);
        return ResponseDto.ok(response);
    }

    @ApiOperation(value = "Pokemon 전체 조회")
    @GetMapping(value = "/search/all")
    public ResponseEntity<?> getAll(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        var response = pokemonService.getAll(pageable);
        return PageDto.ok(response);
    }

    @ApiOperation(value = "Pokemon 수정하기")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody PokemonUpdateRequest request
    ) {
        var response = pokemonService.update(id, request);

        return ResponseDto.ok(response);
    }

    @ApiOperation(value = "Pokemon 삭제하기")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pokemonService.delete(id);
        return ResponseDto.noContent();
    }

}
