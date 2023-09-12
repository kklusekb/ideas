package michal.jakubiak.ideas.handlers;

import michal.jakubiak.ideas.input.UserInputCommand;

public class CategoryCommandHandler extends BaseCommandHandler {


    private static final String COMMAND_NAME = "category";

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        switch (command.getAction())
        {
            case "list" :
                System.out.println("Category list:");
                break;
            case "add" :
                System.out.println("Add category");
                break;
            default:
                throw new IllegalArgumentException(String.format("Unknow action %s from command %s",command.getAction(),command.getCommand()));

        }
    }
}
