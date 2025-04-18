package com.zuca.zuca_bot.domain.models.dto;

import java.util.ArrayList;

public record Standing(String stage, String type, Object group, ArrayList<Table> table) {
}
