package com.mtah.persistence.Service;

import java.util.List;

public interface EntityService<T, ID> {

    List<T> findAll();

    T findById(ID id);

    void deleteById(ID id);

    T save(T object);
}
