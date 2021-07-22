package com.bnamericas.api;

import java.util.List;
import java.util.Optional;

/**
 * @author janezmejias.09@gmail.com
 * @version 1.0
 * @param <T>
 * @see
 */
public interface ServiceBase<T> {

    T save(T model) throws Exception;

    Optional<T> findById(Long id) throws Exception;

    boolean existsById(Long id) throws Exception;

    List<T> findAll() throws Exception;

    long count() throws Exception;

    void deleteById(Long id) throws Exception;

    void delete(T model) throws Exception;

    void deleteAll() throws Exception;

}
