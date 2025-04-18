package com.zuca.zuca_bot.repository;

import com.zuca.zuca_bot.domain.models.entity.CachedCompetitionMatches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CachedCompetitionMatchesRepository extends JpaRepository<CachedCompetitionMatches, Integer> {}
