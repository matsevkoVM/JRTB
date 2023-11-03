package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.services.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.javarushcommunity.jrtb.command.CommandName.*;

/**
 * Help {@link Command}.
 */

public class HelpCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    final static String HELP_MESSAGE = String.format("✨<b>Available commands</b>✨\n\n" +
                    "<b>Start\\Stop work with bot</b>\n" +
                    "%s - start to work with me.\n" +
                    "%s - suspend working with me.\n\n" +
                    "<b>Statistics</b>\n" +
                    "%s - get statistics. \n\n" +
                    "<b>Help</b>\n" +
                    "%s - get help\n",
            START.getCommandName(), STOP.getCommandName(),STATISTICS.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
