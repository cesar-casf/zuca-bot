package com.zuca.zuca_bot.domain.models.dto;

import java.util.ArrayList;

public record TopScorers(int count, Filters filters, Competition competition, Season season,
                         ArrayList<Scorer> scorers) {
}
