package com.spring.pokemondungeon.service;

import com.spring.pokemondungeon.dto.request.skill.SkillRegisterRequest;
import com.spring.pokemondungeon.dto.response.SkillResponse;
import com.spring.pokemondungeon.entity.Skill;
import com.spring.pokemondungeon.exception.PokemonException;
import com.spring.pokemondungeon.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SkillService {
    private final SkillRepository skillRepository;

    @Transactional
    public SkillResponse register(SkillRegisterRequest request){
        Skill skill = new Skill(
                request.getSkillName(),
                request.getDamage()
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
}
