package com.zuca.zuca_bot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuca.zuca_bot.client.FootballDataClient;
import com.zuca.zuca_bot.domain.models.entity.CachedCompetitionMatches;
import com.zuca.zuca_bot.domain.models.entity.CachedStandings;
import com.zuca.zuca_bot.domain.models.entity.CachedStandingsRepository;
import com.zuca.zuca_bot.repository.CachedCompetitionMatchesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class FootballCacheService {

    private final FootballDataClient client;
    private final ObjectMapper objectMapper;
    private final CachedCompetitionMatchesRepository matchesRepo;
    private final CachedStandingsRepository standingsRepo;

    public FootballCacheService(FootballDataClient client, ObjectMapper objectMapper,
                                CachedCompetitionMatchesRepository matchesRepo,
                                CachedStandingsRepository standingsRepo) {
        this.client = client;
        this.objectMapper = objectMapper;
        this.matchesRepo = matchesRepo;
        this.standingsRepo = standingsRepo;
    }

    public void updateCompetition(Integer competitionId, Integer seasonYear) {
        client.fetchCompetitionMatches(competitionId, seasonYear)
                .flatMap(matches -> {
                    try {
                        String json = objectMapper.writeValueAsString(matches);
                        CachedCompetitionMatches cache = new CachedCompetitionMatches();
                        cache.setCompetitionId(competitionId);
                        cache.setSeasonYear(seasonYear);
                        cache.setJsonData(json);
                        cache.setLastUpdated(LocalDateTime.now());
                        matchesRepo.save(cache);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace(); // log melhor no futuro
                    }
                    return Mono.empty();
                }).subscribe();

        client.fetchStandings(competitionId, seasonYear)
                .flatMap(standings -> {
                    try {
                        String json = objectMapper.writeValueAsString(standings);
                        CachedStandings cache = new CachedStandings();
                        cache.setCompetitionId(competitionId);
                        cache.setSeasonYear(seasonYear);
                        cache.setJsonData(json);
                        cache.setLastUpdated(LocalDateTime.now());
                        standingsRepo.save(cache);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return Mono.empty();
                }).subscribe();
    }
}
