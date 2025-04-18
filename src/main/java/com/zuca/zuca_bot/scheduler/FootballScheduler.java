package com.zuca.zuca_bot.scheduler;

import com.zuca.zuca_bot.service.FootballCacheService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Year;

@Component
@EnableScheduling
public class FootballScheduler {

    private final FootballCacheService cacheService;

    public FootballScheduler(FootballCacheService cacheService) {
        this.cacheService = cacheService;
    }

    // A cada minuto
    @Scheduled(fixedRate = 60000)
    public void scheduleUpdate() {
        int anoAtual = Year.now().getValue();

        cacheService.updateCompetition(2013, anoAtual); // Brasileirao
        cacheService.updateCompetition(2017, anoAtual); // Copa do Brasil
        cacheService.updateCompetition(2152, anoAtual); // Libertadores
        cacheService.updateCompetition(2001, anoAtual); // Champions League
    }
}
