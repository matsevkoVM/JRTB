package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.bot.JavaRushTelegramBot;
import com.github.javarushcommunity.jrtb.services.SendBotMessageService;
import com.github.javarushcommunity.jrtb.services.impl.SendBotMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Abstract class for testing {@link Command}s.
 */

public abstract class AbstractCommandTest {

    protected JavaRushTelegramBot javaRushBot = Mockito.mock(JavaRushTelegramBot.class);
    protected SendBotMessageService service = new SendBotMessageServiceImpl(javaRushBot);

    abstract String getCommandName();
    abstract String getCommandMessage();
    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        Long chatId = 1234567890987654321L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sm = new SendMessage();
        sm.setChatId(chatId.toString());
        sm.setText(getCommandMessage());
        sm.enableHtml(true);

        getCommand().execute(update);

        Mockito.verify(javaRushBot).execute(sm);
    }
}
