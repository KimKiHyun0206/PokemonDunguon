package com.spring.pokemondungeon.controller;

import com.spring.pokemondungeon.common.dto.ResponseDto;
import com.spring.pokemondungeon.dto.request.PokemonRegisterRequest;
import com.spring.pokemondungeon.entity.Pokemon;
import com.spring.pokemondungeon.service.PokemonService;
import com.spring.pokemondungeon.service.PokemonValidationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Api(tags = {"Pokemon API"})
@RestController
@RequestMapping(value = "/api/v1/pokemon", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;
    private final PokemonValidationService pokemonValidationService;

    @ApiOperation(value = "Pokemon 등록하기")
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE  )
    public ResponseEntity<?> startGame(@RequestBody PokemonRegisterRequest request, Pageable pageable){

        if(pokemonService.getSizeOfPokemon(pageable)>0){
            return ResponseDto.noContent();
        }

        if(pokemonValidationService.isPokemonIsValidate(request)){
            var response = pokemonService.register(request);
            return ResponseDto.created(response);
        }

        return ResponseDto.noContent();
    }

}
