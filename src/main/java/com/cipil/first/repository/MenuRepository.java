package com.cipil.first.repository;

import com.cipil.first.model.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dinco-WORK on 23.06.2017.
 */
public interface MenuRepository extends CrudRepository<Menu, Long> {
    Iterable<Menu> findByMenuLevel(Integer menuLevel);
}