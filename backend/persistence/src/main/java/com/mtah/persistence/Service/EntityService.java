package com.mtah.persistence.Service;

public abstract class EntityService<T, ID> {

    public abstract void deleteById(Long id);

    public abstract T save(T t);
}
