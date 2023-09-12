package michal.jakubiak.ideas.handlers;

import michal.jakubiak.ideas.input.UserInputCommand;

public class HelpCommandHandler extends BaseCommandHandler {

    public static final String COMMAND_NAME = "help";

    @Override
    public void handle(UserInputCommand command) {
        System.out.println("Help");
        System.out.println("<Command>  <Action> <param1>  <param2>  <param3>");
        System.out.println("Commands: help  category quite");
    }


    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }
}
