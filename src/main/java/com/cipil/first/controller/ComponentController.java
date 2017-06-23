package com.cipil.first.controller;

import com.cipil.first.model.Component;
import com.cipil.first.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dinco-WORK on 23.06.2017.
 */
@RestController
@RequestMapping("/components")
public class ComponentController {

    @Autowired
    ComponentRepository repository;

    @RequestMapping(value = "/auto/{filterText}")
    List<Component> getComponentsAutocomplete(@PathVariable String filterText){
        if(filterText.equalsIgnoreCase(""))
            return null;
        List<Component> components = repository.findByNameContaining(filterText);
        return components;
    }
}
