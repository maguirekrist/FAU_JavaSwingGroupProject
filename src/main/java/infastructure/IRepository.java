package infastructure;

import model.Entity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

//The repository pattern is both a domain specific pattern for these types of applications (i.e. CRUD based business apps) and an example of the bridge pattern.
/**
 * Repository interface for subclasses of Entity
 * @param <T> extends Entity
 */
public interface IRepository<T extends Entity> extends IObservable, Cloneable {

    /**
     * @param id corresponding to the entity's id
     * @return an optional entity subclass, when ID is not found, there is no value present in the optional.
     */
    Optional<T> getById(int id);

    /**
     * @return a list of subclasses of entity
     */
    List<T> list();


    /**
     * @param pred filter
     * @return list of entities that satisfy the predicate in parameter
     */
    List<T> list(Predicate<T> pred);

    /**
     * inserts a new entity into memory, in order to persist, you must call save afterwards
     * @param entity
     */
    void insert(T entity);

    /**
     * updates an existing entity in the repository with the one passed in the parameter, needs to be saved
     * @param entity
     */
    void update(T entity);

    /**
     * deletes an entity from the repository, needs to be saved
     * @param entity
     */
    void delete(T entity);

    /**
     * persists any repository changes, like update, delete, and insert.
     */
    void save();
}
