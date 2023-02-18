package com.spring.pokemondungeon.service.validation;

import com.spring.pokemondungeon.entity.Skill;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SkillValidationService {
    public int upgradeSkill(Skill skill) {
        if(isSkillUpgrade(skill)){
            return (int) (skill.getDamage() * 1.5);
        }
        return skill.getDamage();
    }

    private boolean isSkillUpgrade(Skill skill) {
        return skill.getUpgrade() < 2;
    }
}
