package com.zuca.zuca_bot.bot.command.listener;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FalaCommandListener extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("fala")) {
            String content = Objects.requireNonNull(event.getOption("conteudo")).getAsString();
            event.reply(String.format("%s me pediu para falar: %s", event.getUser().getName(), content)).queue(); // O bot responde imediatamente
        }
    }
}
