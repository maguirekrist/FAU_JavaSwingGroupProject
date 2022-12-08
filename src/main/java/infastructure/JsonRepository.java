package infastructure;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Entity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


/**
 * Represents a repository for T utilizing JSON files as its storage medium
 * @param <T> where T extends Entity
 */
public class JsonRepository<T extends Entity> extends Observable implements IRepository<T> {

    private Collection<T> aggregate = new ArrayList<>();
    private String _className;
    private TypeToken<ArrayList<T>> _entityType;

    public JsonRepository(String className, TypeToken<ArrayList<T>> entity) throws IOException {
        this._className = className;
        this._entityType = entity;

        File file = new File(className + ".json");

        if(file.exists()) {
            try {
                String data = Files.readString(Path.of(className + ".json"));

                var temp = new Gson().fromJson(data, _entityType);

                aggregate = temp != null ? temp : aggregate;
            } catch(IOException ex) {
                //do nothing
                return;
            }
        } else {
            file.createNewFile();
        }
    }

    @Override
    public void save() {
        Gson gson = new Gson();
        String jsonExample = gson.toJson(aggregate);
        try {
            var writer = new BufferedWriter(new FileWriter(_className + ".json"));
            writer.write(jsonExample);
            writer.close();
        } catch(IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Optional<T> getById(int id) {
        return aggregate.stream().filter(e -> e.id == id).findFirst();
    }

    @Override
    public List<T> list() {
        return aggregate.stream().toList();
    }

    @Override
    public List<T> list(Predicate<T> pred) {
        return aggregate.stream().filter(pred).toList();
    }

    @Override
    public void insert(final T entity) {
        entity.id = aggregate.size() + 1;
        aggregate.add(entity);
    }

    @Override
    public void update(T entity) {
        aggregate.stream().map(e -> {
            if(e.id == entity.id) {
                return entity;
            }
            return e;
        }).toList();
    }

    @Override
    public void delete(T entity) {
        aggregate = aggregate.stream().filter(e -> e.id != entity.id).toList();
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
