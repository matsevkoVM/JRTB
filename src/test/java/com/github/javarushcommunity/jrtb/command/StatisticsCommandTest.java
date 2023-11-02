package com.github.javarushcommunity.jrtb.command;

import static com.github.javarushcommunity.jrtb.command.CommandName.STATISTICS;
import static com.github.javarushcommunity.jrtb.command.StatisticsCommand.STATISTICS_MESSAGE;

class StatisticsCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return STATISTICS.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(STATISTICS_MESSAGE, 0);
    }

    @Override
    Command getCommand() {
        return null;
    }
}