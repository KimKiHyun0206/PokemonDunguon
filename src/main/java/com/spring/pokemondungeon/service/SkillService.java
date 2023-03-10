package com.spring.pokemondungeon.service;

import com.spring.pokemondungeon.dto.request.skill.SkillRegisterRequest;
import com.spring.pokemondungeon.dto.response.SkillResponse;
import com.spring.pokemondungeon.entity.Pokemon;
import com.spring.pokemondungeon.entity.Skill;
import com.spring.pokemondungeon.exception.PokemonException;
import com.spring.pokemondungeon.repository.SkillRepository;
import com.spring.pokemondungeon.service.validation.SkillValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SkillService {
    private final SkillRepository skillRepository;
    private final SkillValidationService skillValidationService;

    @Transactional
    public SkillResponse register(SkillRegisterRequest request){
        Skill skill = new Skill(
                request.getSkillName(),
                request.getDamage(),
                0
        );

        Skill response = skillRepository.save(skill);
        log.info("skill 등록했습니다. {}", response.getSkillName());
        return SkillResponse.from(response);
    }

    @Transactional(readOnly = true)
    public SkillResponse get(String skillName){
        Skill skill = skillRepository.findById(skillName).orElseThrow(PokemonException::new);

        return SkillResponse.from(skill);
    }

    @Transactional(readOnly = true)
    public SkillResponse upgrade(String skillName){
        Skill skill = skillRepository.findById(skillName).orElseThrow(PokemonException::new);

        int upgradeDamage = skillValidationService.upgradeSkill(skill);

        skill.upgrade(upgradeDamage);

        log.info("Skill Upgrade. {}",skillName);

        return SkillResponse.from(skill);
    }

    @Transactional(readOnly = true)
    public Skill mapping(Pokemon pokemon){
        String skillName = pokemon.getSkill();

        return skillRepository
                .findById(skillName)
                .orElseThrow(PokemonException::new);
    }
}
