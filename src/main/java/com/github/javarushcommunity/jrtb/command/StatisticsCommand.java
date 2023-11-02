package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.services.SendBotMessageService;
import com.github.javarushcommunity.jrtb.services.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Statistics {@link Command}.
 */

public class StatisticsCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    protected final static String STATISTICS_MESSAGE = "%d persons use the bot";

    public StatisticsCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        int activeUserCount = telegramUserService.getAllActiveUsers().size();
        String chatId = update.getMessage().getChatId().toString();

        sendBotMessageService.sendMessage(chatId, String.format(STATISTICS_MESSAGE, activeUserCount));
    }
}
