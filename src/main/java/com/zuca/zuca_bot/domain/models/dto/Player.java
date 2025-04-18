package com.zuca.zuca_bot.domain.models.dto;

import java.time.LocalDateTime;

public record Player(int id, String name, String firstName, String lastName, String dateOfBirth, String nationality,
                     String section, Object position, int shirtNumber, LocalDateTime lastUpdated) {
}
