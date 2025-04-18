package com.zuca.zuca_bot.domain.models.dto;

public record Table(int position, Team team, int playedGames, String form, int won, int draw, int lost, int points,
                    int goalsFor, int goalsAgainst, int goalDifference) {
}
