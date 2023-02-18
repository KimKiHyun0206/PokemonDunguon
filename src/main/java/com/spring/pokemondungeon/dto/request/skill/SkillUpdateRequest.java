package com.spring.pokemondungeon.dto.request.skill;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SkillUpdateRequest {
    private String skillName;
    private int damage;
}
