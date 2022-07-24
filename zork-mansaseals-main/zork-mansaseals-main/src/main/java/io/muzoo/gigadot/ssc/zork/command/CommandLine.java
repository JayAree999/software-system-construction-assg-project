package io.muzoo.gigadot.ssc.zork.command;

public class CommandLine {
    private CommandType commandType;
    private String argument;

    public CommandLine(CommandType commandType, String argument) {
        this.commandType = commandType;
        this.argument = argument;
    }

    public CommandType getCommandType() {
        return commandType;
    }




    public String getArgument() {
        return argument;
    }


}
