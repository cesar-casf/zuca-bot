package com.zuca.zuca_bot.domain.models.dto;

public record Scorer(Player player, Team team, int playedMatches, int goals, int assists, int penalties) {
}