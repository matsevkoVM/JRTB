package com.github.javarushcommunity.jrtb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.javarushcommunity.jrtb.command.CommandName.NO;
import static com.github.javarushcommunity.jrtb.command.NoCommand.NO_COMMAND;

@DisplayName("Unit-level testing for NoCommand")
class NoCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_COMMAND;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}