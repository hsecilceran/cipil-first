package com.cipil.first.controller;

import com.cipil.first.model.Menu;
import com.cipil.first.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dinco-WORK on 23.06.2017.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    MenuRepository repository;

    @RequestMapping(path = "/bylevel/{menuLevel}")
    Iterable<Menu> findByLevel(@PathVariable Integer menuLevel){
        return repository.findByMenuLevel(menuLevel);
    }
}
