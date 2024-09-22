package utp.restaurant.dao;

import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.Category;

public class CategoryDAO implements DAO<Category> {

    private ArrayList<Category> categoryList;

    public CategoryDAO() {
        categoryList = RestaurantDB.getInstance().getCategoryList();
    }

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
    public void add(Category category) {
        categoryList.add(category);
    }

    @Override
    public void update(long id, Category category) {
        categoryList.set(getIndex(id), category);
    }

    @Override
    public void delete(long id) {
        categoryList.remove(getIndex(id));
    }

    private int getIndex(long id) {
        return categoryList.indexOf(get(id));
    }

}
