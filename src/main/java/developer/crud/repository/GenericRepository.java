package developer.crud.repository;

import java.util.List;

public interface GenericRepository<T, ID> {

    T findById(ID id) throws Exception;

    List<T> findAll() throws Exception;

    int create(T item) throws Exception;

    int delete(Long id) throws Exception;

    int update(T item) throws Exception;

}
