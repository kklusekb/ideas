package michal.jakubiak.ideas.handlers;

import michal.jakubiak.ideas.input.UserInputCommand;

public interface CommandHandler {
    void handle(UserInputCommand command);
    boolean supports (String name);

}
