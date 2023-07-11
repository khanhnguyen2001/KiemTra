package management.iManagement;

import java.util.List;

public interface Management<E> {
    void add(E e);

    void edit(String id, E e);

    void delete(String id);

    int findIndexById(String id);

    List<E> getAll();
}
