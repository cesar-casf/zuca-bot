package com.zuca.zuca_bot.client;

import com.zuca.zuca_bot.domain.models.dto.CompetitionMatches;
import com.zuca.zuca_bot.domain.models.dto.Standings;
import com.zuca.zuca_bot.domain.models.dto.TeamMatches;
import com.zuca.zuca_bot.domain.models.dto.TopScorers;
import reactor.core.publisher.Mono;

public interface FootballDataClient {
    public Mono<CompetitionMatches> fetchCompetitionMatches(Integer competitionId, Integer seasonYear);
    public Mono<Standings> fetchStandings(Integer competitionId, Integer seasonYear);
    public Mono<TopScorers> fetchTopScorers(Integer competitionId, Integer seasonYear);
    public Mono<TeamMatches> fetchTeamMatches(Integer teamId, Integer seasonYear);
}
