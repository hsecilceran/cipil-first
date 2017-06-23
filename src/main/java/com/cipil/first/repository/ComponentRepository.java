package com.cipil.first.repository;

import com.cipil.first.model.Component;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dinco-WORK on 23.06.2017.
 */
public interface ComponentRepository extends CrudRepository<Component, Long> {
    List<Component> findByNameContaining(String name);
}
