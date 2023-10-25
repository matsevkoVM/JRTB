package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.services.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Unknown {@link Command}.
 */

public class UnknownCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    private final static String UNKNOWN_MESSAGE = "I don't understand you \uD83D\uDE1F. " +
            "Type '/help' to find out what I understand.";

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
