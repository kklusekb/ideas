package michal.jakubiak.ideas.dao;

import michal.jakubiak.ideas.model.Category;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    public List<Category> findAll() {

        try {
            List<String> lines = Files.readAllLines(Paths.get("./categories.txt"));
            List<Category> categories = new ArrayList<>();
            for(String line : lines)
            {
                categories.add(new Category(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


    public void add(Category category) {
    }
}
