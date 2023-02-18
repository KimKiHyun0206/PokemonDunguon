package com.spring.pokemondungeon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class PokemonDungeonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonDungeonApplication.class, args);
    }

}
