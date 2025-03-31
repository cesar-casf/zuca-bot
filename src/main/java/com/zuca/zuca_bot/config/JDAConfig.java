package com.zuca.zuca_bot.config;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;
import java.util.List;

@Configuration
public class JDAConfig {
    @Value("${secret.discord-token}")
    private String discordToken;

    @Bean
    public JDA jda(List<ListenerAdapter> eventListeners) throws InterruptedException {
        JDABuilder builder = JDABuilder
                .createDefault(discordToken, EnumSet.of(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT));

        // Adiciona todos os listeners anotados como @Component
        eventListeners.forEach(builder::addEventListeners);

        return builder.build();
    }
}
