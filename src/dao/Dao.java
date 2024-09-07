package dao;

import java.util.ArrayList;

public interface Dao<T> {
    ArrayList<T> getAll();
    T get(long id);
    void add(T t);
    void update(long id, T t);
    void delete(long id);
}
