package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.services.SendBotMessageService;
import com.github.javarushcommunity.jrtb.services.TelegramUserService;
import com.google.common.collect.ImmutableMap;
import static com.github.javarushcommunity.jrtb.command.CommandName.*;

/**
 * Container of the {@link Command}s, which are using for handling telegram commands.
 */

public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

   public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService){
       commandMap = ImmutableMap.<String, Command>builder()
               .put(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService))
               .put(STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService))
               .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
               .put(STATISTICS.getCommandName(), new StatisticsCommand(sendBotMessageService, telegramUserService))
               .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
               .build();

       unknownCommand = new UnknownCommand(sendBotMessageService);
   }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
