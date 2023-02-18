package com.spring.pokemondungeon.dto.response;

import com.spring.pokemondungeon.entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SkillResponse {
    private final String skillName;
    private final int damage;

    public static SkillResponse from(Skill skill) {
        return new SkillResponse(
                skill.getSkillName(),
                skill.getDamage()
        );
    }
}
