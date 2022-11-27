package infastructure;

import com.google.gson.reflect.TypeToken;
import model.Entity;

import java.util.ArrayList;

public class RepositoryFactory {

    private IRepository instance;

    public <T extends Entity> void setInstance(IRepository<T> repo) {
        instance = repo;
    }

    public <T extends Entity> IRepository<T> getInstance() {
        if (instance == null) {
            return new MemoryRepository<T>();
        }

        return instance;
    }


}
