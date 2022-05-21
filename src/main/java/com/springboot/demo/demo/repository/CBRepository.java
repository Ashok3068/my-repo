package com.springboot.demo.demo.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
public interface CBRepository {
    public <T> Object save(T t, String id) throws IOException;
    public <K> Optional<Object>  getById(K k) throws IOException;
    public <K> String  deleteBy(K k);
}
