package com.mtah.persistence.Service;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityService<T, ID> {

    public List<T> findAll() {
        List<T> items = new ArrayList<T>();
        return items;
    }

    public abstract T findById(Long id);

    public abstract void deleteById(Long id);

    public abstract T save(T t);
}
