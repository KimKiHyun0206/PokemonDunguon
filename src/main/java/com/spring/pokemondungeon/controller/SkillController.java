package com.spring.pokemondungeon.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Pokemon Skill API"})
@RestController
@RequestMapping(value = "/api/v1/skill", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SkillController {
}
