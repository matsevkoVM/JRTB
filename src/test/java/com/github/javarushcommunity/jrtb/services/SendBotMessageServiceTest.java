package com.github.javarushcommunity.jrtb.services;

import com.github.javarushcommunity.jrtb.bot.JavaRushTelegramBot;
import com.github.javarushcommunity.jrtb.services.impl.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
class SendBotMessageServiceTest {

    private SendBotMessageService service;
    private JavaRushTelegramBot telegramBot;

    @BeforeEach
    public void init(){
        telegramBot = Mockito.mock(JavaRushTelegramBot.class);
        service = new SendBotMessageServiceImpl(telegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {

        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sm = new SendMessage();
        sm.setText(message);
        sm.setChatId(chatId);
        sm.enableHtml(true);

        service.sendMessage(chatId, message);
        Mockito.verify(telegramBot).execute(sm);
    }
}