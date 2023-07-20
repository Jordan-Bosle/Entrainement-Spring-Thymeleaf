package training.demo.repositories;

import org.springframework.stereotype.Repository;
import training.demo.entities.Personne;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonneRepository {

    private static Map<Long, Personne> data = new HashMap<>();

    private long nextId = 5L;

    static {
        Personne p = new Personne(1, "Jordan", "Bosle", 25);
        p.setId(1L);
        data.put(1L, p);
        p = new Personne(2, "Yassin", "Azougagh ", 5);
        p.setId(2L);
        data.put(2L, p);
        p = new Personne(3, "Michael", "Jordan", 149);
        p.setId(3L);
        data.put(3L, p);
        p = new Personne(4, "Lebron", "James", 90);
        p.setId(4L);
        data.put(4L, p);
    }

    public Personne saveOrUpdate(Personne p) {
        if (p.getId() == 0) {
            p.setId(nextId);
            data.put(nextId, p);
            return data.get(nextId++);
        } else {
            data.put(p.getId(), p);
            return data.get(p.getId());
        }

    }

    public void remove(long id) throws Exception {
        if (!data.containsKey(id)) {
            throw new Exception();
        }
        data.remove(id);
    }

    public void remove(Personne p) {
        data.remove(p.getId());
    }

    public Personne findById(long id) {
        return data.get(id);
    }

    public List<Personne> findAll() {
        return data.values().stream().toList();
    }


}
