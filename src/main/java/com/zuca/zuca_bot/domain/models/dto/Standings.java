package com.zuca.zuca_bot.domain.models.dto;

import java.util.ArrayList;

public record Standings(Filters filters, Area area, Competition competition, Season season,
                        ArrayList<Standing> standings) {
}
