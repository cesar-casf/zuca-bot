package com.zuca.zuca_bot.bot.listener;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FlamengoCommandListener extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("flamengo")) {
            event.reply(event.getUser().getName() + "disse que o Flamengo é o melhor time do mundo!").queue(); // O bot responde imediatamente
        }
    }
}
