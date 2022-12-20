package com.markteplace.core.generic;

import com.markteplace.core.error.NotFoundException;
import com.markteplace.core.error.UsernameAlreadyExistsException;

import java.util.List;

public interface AbstractEntityService<T extends AbstractEntity>{
    List<T> findAll();

    T findById(String id) throws NotFoundException;

    T create(T entity);

    T save(T entity);

    T updateById(String id, T entity) throws NotFoundException, UsernameAlreadyExistsException;

    void deleteById(String id) throws NotFoundException;

    boolean existsById(String id);

    T createIfNotExist(T entity);

    T findByValue(T entity);
}
