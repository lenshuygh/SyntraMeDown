package handmedown.repository;

import handmedown.model.HandMeDown;

import java.util.Set;

public interface HandMeDownRepository<E extends HandMeDown> {
    void add(E e);

    Set<E> getAll();

    Set<E> getAll(String searchTerm);
}
