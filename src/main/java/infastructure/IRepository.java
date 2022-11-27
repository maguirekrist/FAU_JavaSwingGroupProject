package infastructure;

import model.Entity;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public interface IRepository<T extends Entity> extends IObservable {

    T getById(int id);

    List<T> list();

    List<T> list(Predicate<T> pred);

    void insert(T entity);

    void update(T entity);

    void delete(T entity);

    void save();
}
