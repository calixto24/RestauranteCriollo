package dao;

import java.util.ArrayList;

public interface Dao<T> {
    ArrayList<T> getAll();
    void add(T t);
//    void update
//    void delete
}
