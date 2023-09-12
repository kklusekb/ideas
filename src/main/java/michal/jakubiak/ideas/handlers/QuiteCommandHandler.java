package michal.jakubiak.ideas.handlers;

import michal.jakubiak.ideas.QuiteIdeasApplicationExeption;
import michal.jakubiak.ideas.input.UserInputCommand;

public class QuiteCommandHandler extends BaseCommandHandler {

    public static final String COMMAND_NAME = "quite";

    @Override
    public void handle(UserInputCommand command) {
        System.out.println("QUITE");
        throw new QuiteIdeasApplicationExeption();
    }


    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }
}
