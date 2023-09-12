package michal.jakubiak.ideas.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInputCommandTest {


    @Test
    void shouldBuiltCorrectUserInputCommad() {

        String input="category add CategoryName";

        UserInputCommand userInputCommand = new UserInputCommand(input);

        Assertions.assertEquals("category",userInputCommand.getCommand());
        Assertions.assertEquals("add",userInputCommand.getAction());
        Assertions.assertLinesMatch(List.of("CategoryName"),userInputCommand.getParam());
    }

    @Test
    void shouldBuiltCorrectUserInputCommadWithMultipleParams() {

        String input="command action param1 param2 param3 param4";

        UserInputCommand userInputCommand = new UserInputCommand(input);

        Assertions.assertEquals("command",userInputCommand.getCommand());
        Assertions.assertEquals("action",userInputCommand.getAction());
        Assertions.assertLinesMatch(List.of("param1","param2","param3","param4"),userInputCommand.getParam());
    }


}