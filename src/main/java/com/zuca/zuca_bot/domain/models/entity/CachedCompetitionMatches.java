package com.zuca.zuca_bot.domain.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class CachedCompetitionMatches {
    @Id
    private Integer competitionId;

    private Integer seasonYear;

    @Lob
    private String jsonData;

    private LocalDateTime lastUpdated;
}