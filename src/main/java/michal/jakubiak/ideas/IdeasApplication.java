package michal.jakubiak.ideas;


import michal.jakubiak.ideas.handlers.CategoryCommandHandler;
import michal.jakubiak.ideas.handlers.CommandHandler;
import michal.jakubiak.ideas.handlers.HelpCommandHandler;
import michal.jakubiak.ideas.handlers.QuiteCommandHandler;
import michal.jakubiak.ideas.input.UserInputCommand;
import michal.jakubiak.ideas.input.UserInputMenager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IdeasApplication {

    public static void main(String[] args) {
        new IdeasApplication().start();

    }

    private void start() {
        System.out.println("App start");

        UserInputMenager userInputMenager = new UserInputMenager();
        List<CommandHandler> handlers = new ArrayList<>();
        handlers.add(new HelpCommandHandler()); //help
        handlers.add(new QuiteCommandHandler());
        handlers.add(new CategoryCommandHandler());

        boolean applicationLoop = true;
        while (applicationLoop) {
            try {
                UserInputCommand userInputCommand = userInputMenager.nextCommand();
                System.out.println(userInputCommand);
                Optional<CommandHandler> currentHandler = Optional.empty();
                for (CommandHandler handler : handlers) {
                    if (handler.supports(userInputCommand.getCommand())) {
                        currentHandler = Optional.of(handler);
                        break;
                    }
                }
                currentHandler.orElseThrow(() -> new IllegalArgumentException("unknow handler: " + userInputCommand.getCommand())).handle(userInputCommand);
            } catch (QuiteIdeasApplicationExeption e) {
                System.out.println("Koniec");
                applicationLoop = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
