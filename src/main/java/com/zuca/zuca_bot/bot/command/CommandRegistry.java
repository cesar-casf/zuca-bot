package com.zuca.zuca_bot.bot.command;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CommandRegistry extends ListenerAdapter {
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        List<CommandData> commands = List.of(
                Commands.slash("fala", "Faz o bot repetir uma mensagem")
                        .addOption(OptionType.STRING, "conteudo", "O que bot deve falar", true),
                Commands.slash("status", "Retorna status do bot")

        );
        event.getJDA().updateCommands().addCommands(commands).queue();
        log.info("Comandos inseridos!");
    }
}
