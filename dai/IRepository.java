package dai;

import java.util.*;

public interface IRepository<Entity, key> {

    List<Entity> getAll() throws Exception;

    Entity find(key k) throws Exception;

    void create(Entity e) throws Exception;

    void update(Entity e) throws Exception;

    void delete(Entity e) throws Exception;
}
