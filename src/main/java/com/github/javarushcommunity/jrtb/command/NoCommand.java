package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.services.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * No {@link Command}.
 */

public class NoCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    private final static String NO_COMMAND = "I support commands starting with a slash (/). " +
            "To see the list of commands, enter /help.";

    public NoCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_COMMAND);
    }
}
