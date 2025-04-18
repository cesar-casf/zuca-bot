package com.zuca.zuca_bot.domain.models.dto;

public record Season(int id, String startDate, String endDate, int currentMatchday, Object winner) {
}
