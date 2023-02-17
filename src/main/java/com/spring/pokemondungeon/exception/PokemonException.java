package com.spring.pokemondungeon.exception;

public class PokemonException extends BusinessException {
    public PokemonException() {
        super(ErrorMessage.TODO_NOT_FOUND_ERROR);
    }
}
