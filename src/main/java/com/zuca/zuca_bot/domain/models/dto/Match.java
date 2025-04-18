package com.zuca.zuca_bot.domain.models.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public record Match(Area area, Competition competition, Season season, int id, LocalDateTime utcDate, String status,
                    int matchday, String stage, Object group, LocalDateTime lastUpdated, Team homeTeam, Team awayTeam,
                    Score score, Odds odds, ArrayList<Object> referees) {
}
