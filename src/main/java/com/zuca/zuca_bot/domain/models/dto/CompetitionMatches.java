package com.zuca.zuca_bot.domain.models.dto;

import java.util.ArrayList;

public record CompetitionMatches(Filters filters, ResultSet resultSet, Competition competition, ArrayList<Match> matches) {
}
