package weekend.cinema.dao;

import weekend.cinema.AbstractEntity;

import java.util.List;

public interface AbstractDao<T extends AbstractEntity> {

    void save(T t);

    void delete(T t);

    T findById(int id);

    List<T> findAll();
}
