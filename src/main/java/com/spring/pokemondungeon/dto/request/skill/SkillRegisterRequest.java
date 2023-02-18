package com.spring.pokemondungeon.dto.request.skill;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SkillRegisterRequest {
    private String skillName;
    private int damage;
}
