package com.spring.pokemondungeon.controller;

import com.spring.pokemondungeon.common.dto.ResponseDto;
import com.spring.pokemondungeon.dto.request.skill.SkillRegisterRequest;
import com.spring.pokemondungeon.service.SkillService;
import com.spring.pokemondungeon.service.validation.SkillValidationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Pokemon Skill API"})
@RestController
@RequestMapping(value = "/api/v1/skill", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @ApiOperation(value = "Skill 등록")
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody SkillRegisterRequest request){
        skillService.register(request);

        return ResponseDto.ok(request);
    }

    @ApiOperation(value = "Skill 업그레이드")
    @PutMapping(value = "/upgrade/{skillName}")
    public ResponseEntity<?> upgrade(@PathVariable String skillName){
        var response = skillService.upgrade(skillName);

        return ResponseDto.ok(response);
    }
}
