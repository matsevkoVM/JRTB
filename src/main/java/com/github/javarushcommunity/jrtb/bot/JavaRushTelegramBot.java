package com.github.javarushcommunity.jrtb.bot;

import com.github.javarushcommunity.jrtb.command.CommandContainer;
import com.github.javarushcommunity.jrtb.command.CommandName;
import com.github.javarushcommunity.jrtb.services.impl.SendBotMessageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Telegram bot for Javarush Community from Javarush community.
 */

@Component
@Slf4j
public class JavaRushTelegramBot extends TelegramLongPollingBot {
    public final static String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String botUsername;
    

    @Value("${bot.token}")
    private String botToken;

    private final CommandContainer commandContainer;

    public JavaRushTelegramBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)){
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(CommandName.NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken(){
        return botToken;
    }

}
