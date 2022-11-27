package infastructure;

import model.Entity;

import java.util.List;
import java.util.function.Predicate;

public class MemoryRepository<T extends Entity> implements IRepository<T> {

    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public List<T> list() {
        return null;
    }

    @Override
    public List<T> list(Predicate<T> pred) {
        return null;
    }

    @Override
    public void insert(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public void save() {

    }
}
