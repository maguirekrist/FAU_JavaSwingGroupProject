package infastructure;

import jdk.jshell.spi.ExecutionControl;
import model.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Represents a repository for T utilizing in  memory objects as its storage medium
 * @param <T> where T extends Entity
 */
public class MemoryRepository<T extends Entity> extends Observable implements IRepository<T> {

    private List<T> _data = new ArrayList<>();

    public MemoryRepository() {}

    public MemoryRepository(List<T> data) {
        this._data = data;
    }

    @Override
    public Optional<T> getById(int id) {
        return _data.stream().filter(e -> e.id == id).findFirst();
    }

    @Override
    public List<T> list() {
        return _data;
    }

    @Override
    public List<T> list(Predicate<T> pred) {
        return _data.stream().filter(pred).toList();
    }

    @Override
    public void insert(T entity) {
        entity.id = _data.size() + 1;
        _data.add(entity);
    }

    @Override
    public void update(T entity) {
        _data.stream().map(e -> {
            if(e.id == entity.id) {
                return entity;
            }
            return e;
        }).toList();
    }

    @Override
    public void delete(T entity) {
        _data.remove(entity);
    }

    @Override
    public void save() {
        try {
            throw new ExecutionControl.NotImplementedException("Cannot save a MemoryRepo");
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
    }
}
