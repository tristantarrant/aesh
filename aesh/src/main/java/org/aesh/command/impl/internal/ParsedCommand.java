package org.aesh.command.impl.internal;

import org.aesh.command.Command;

public class ParsedCommand {

    private final ProcessedCommand processedCommand;

    public ParsedCommand(ProcessedCommand pc) {
        this.processedCommand = pc;
    }

    public ParsedOption findLongOption(String name) {
        ProcessedOption po = processedCommand.findLongOption(name);
        if(po != null)
            return new ParsedOption(po);
        else
            return null;

    }

    public Command command() {
        return processedCommand.getCommand();
    }

    public ParsedOption argument() {
        if(processedCommand.hasArgument())
            return new ParsedOption(processedCommand.getArgument());
        else
            return null;
    }

    public ParsedOption arguments() {
        if(processedCommand.hasArguments())
            return new ParsedOption(processedCommand.getArguments());
        else
            return null;
    }

    public ParsedOption findLongOptionNoActivatorCheck(String name) {
        ProcessedOption processedOption = processedCommand.findLongOptionNoActivatorCheck(name);
        if(processedOption != null)
            return new ParsedOption(processedOption);
        else
            return null;
    }

}
