package com.spring.pokemondungeon.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KnockedDownResponse {
    private final Long knockedDownPokemon;
}
