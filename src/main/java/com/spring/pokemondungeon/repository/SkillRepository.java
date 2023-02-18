package com.spring.pokemondungeon.repository;

import com.spring.pokemondungeon.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, String> {
}
