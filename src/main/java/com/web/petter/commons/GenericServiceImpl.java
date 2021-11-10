package com.web.petter.commons;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public abstract class GenericServiceImpl <T, ID extends Serializable> implements GenericService<T, ID> {



    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);

    }

    @Override
    public T get(ID id) {
        Optional<T> obj = getRepository().findById(id);
        return obj.orElse(null);
    }

    @Override
    public List<T> getAll() {
        List<T> list = new ArrayList<>();
        getRepository().findAll().forEach(object -> list.add(object));
        return list;
    }

    /**
     * Method to get type repository and change for the generic type
     */
    public abstract CrudRepository <T, ID> getRepository();
}
