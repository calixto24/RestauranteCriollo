package utp.restaurant.dao;

import java.util.ArrayList;
import javax.swing.text.html.StyleSheet;
import utp.restaurant.model.Category;

public class CategoryDAO implements DAO<Category> {

    private ArrayList<Category> categoryList;

    @Override
    public ArrayList<Category> getAll() {
        return categoryList;
    }

    @Override
    public Category get(long id) {
        for (Category y : categoryList) {
            if (y.getId() == id) {
                return y;
            }
        }
        return null;
    }

    @Override
    public void add(Category t) {
        categoryList.add(t);
    }

    @Override
    public void update(long id, Category t) {
        categoryList.set(getIndex(id), t);
    }

    @Override
    public void delete(long id) {
        categoryList.remove(getIndex(id));
    }

    private int getIndex(long id) {
        return categoryList.indexOf(get(id));
    }

}
