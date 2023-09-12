package michal.jakubiak.ideas.handlers;

import michal.jakubiak.ideas.dao.CategoryDao;
import michal.jakubiak.ideas.input.UserInputCommand;
import michal.jakubiak.ideas.model.Category;

import java.util.List;

public class CategoryCommandHandler extends BaseCommandHandler {


    private static final String COMMAND_NAME = "category";

    private CategoryDao categoryDao;

    public CategoryCommandHandler() {
        categoryDao = new CategoryDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {

        if (command.getAction() == null) System.out.println("What you want to do?");
        switch (command.getAction()) {
            case "":
                System.out.println();
            case "list":
                System.out.println("Category list:");
                List<Category> categories = categoryDao.findAll();
                categories.forEach(System.out::println);
                break;
            case "add":
                System.out.println("Add category");
                String categoryName = command.getParam().get(0);
                categoryDao.add(new Category(categoryName));
                break;
            default:
                throw new IllegalArgumentException(String.format("Unknow action %s from command %s", command.getAction(), command.getCommand()));

        }
    }
}
