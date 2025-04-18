package com.zuca.zuca_bot.client.impl;

import com.zuca.zuca_bot.client.FootballDataClient;
import com.zuca.zuca_bot.domain.models.dto.CompetitionMatches;
import com.zuca.zuca_bot.domain.models.dto.Standings;
import com.zuca.zuca_bot.domain.models.dto.TeamMatches;
import com.zuca.zuca_bot.domain.models.dto.TopScorers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class FootballDataClientImpl implements FootballDataClient {
    private final WebClient webClient;

    public FootballDataClientImpl(@Value("${secret.football-api-token}") String token) {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.football-data.org/v4")
                .defaultHeader("X-Auth-Token", token)
                .build();
    }

    @Override
    public Mono<CompetitionMatches> fetchCompetitionMatches(Integer competitionId, Integer seasonYear) {
        return webClient.get()
                .uri("/competitions/{id}/matches?season={year}", competitionId, seasonYear)
                .retrieve()
                .bodyToMono(CompetitionMatches.class);
    }

    @Override
    public Mono<Standings> fetchStandings(Integer competitionId, Integer seasonYear) {
        return webClient.get()
                .uri("/competitions/{id}/standings?season={year}", competitionId, seasonYear)
                .retrieve()
                .bodyToMono(Standings.class);
    }

    @Override
    public Mono<TopScorers> fetchTopScorers(Integer competitionId, Integer seasonYear) {
        return webClient.get()
                .uri("/competitions/{id}/scorers?season={year}", competitionId, seasonYear)
                .retrieve()
                .bodyToMono(TopScorers.class);
    }

    @Override
    public Mono<TeamMatches> fetchTeamMatches(Integer teamId, Integer seasonYear) {
        return webClient.get()
                .uri("/teams/{id}/matches?season={year}", teamId, seasonYear)
                .retrieve()
                .bodyToMono(TeamMatches.class);
    }
}
