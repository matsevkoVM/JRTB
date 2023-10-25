package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.services.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Start {@link Command}.
 */

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    private final static String START_MESSAGE = " Hello. I am Java Rush Telegram Bot. I will help you stay up to date " +
            "with the latest articles from those authors that interest you.";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
