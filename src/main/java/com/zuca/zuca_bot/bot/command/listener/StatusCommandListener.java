package com.zuca.zuca_bot.bot.command.listener;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StatusCommandListener extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("status")) {
            event.reply("O Zuca bot está ativo!!").queue(); // O bot responde imediatamente
        }
    }
}
