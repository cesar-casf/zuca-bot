package com.zuca.zuca_bot.bot.listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiveListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return; // Ignora mensagens de bots

        String author = event.getAuthor().getName();
        String message = event.getMessage().getContentRaw();
        String channel = event.getChannel().getName();

        System.out.println("📩 Mensagem recebida!");
        System.out.println("👤 Autor: " + author);
        System.out.println("💬 Mensagem: " + message);
        System.out.println("📌 Canal: " + channel);

        event.getChannel().sendMessage("Olá @" + author).queue();
    }
}
