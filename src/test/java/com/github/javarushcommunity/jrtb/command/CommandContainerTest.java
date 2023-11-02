package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.services.SendBotMessageService;
import com.github.javarushcommunity.jrtb.services.TelegramUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@DisplayName("Unit-level testing for CommandContainer")
class CommandContainerTest {

    private CommandContainer container;

    @BeforeEach
    public void init(){
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
        container = new CommandContainer(sendBotMessageService, telegramUserService);
    }

    @Test
    public void shouldGetAllTheExistingCommands(){
        for (CommandName commandName : CommandName.values()) {
            Command command = container.retrieveCommand(commandName.getCommandName());
            Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
        }
    }

    @Test
    public void shouldReturnTheUnknownCommand(){
        String unknownCommand = "dummyCommand";

        Command command = container.retrieveCommand(unknownCommand);

        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}