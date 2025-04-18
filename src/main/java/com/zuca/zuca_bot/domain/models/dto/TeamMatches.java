package com.zuca.zuca_bot.domain.models.dto;

import java.util.ArrayList;

public record TeamMatches(Filters filters, ResultSet resultSet, ArrayList<Match> matches) {
}
