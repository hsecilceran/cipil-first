package com.cipil.first;

import com.cipil.first.model.Component;
import com.cipil.first.model.Deployment;
import com.cipil.first.model.Menu;
import com.cipil.first.repository.ComponentRepository;
import com.cipil.first.repository.DeploymentRepository;
import com.cipil.first.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.time.LocalDate;

/**
 * Created by Dinco-WORK on 23.06.2017.
 */
@org.springframework.stereotype.Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private DeploymentRepository deploymentRepository;

    @Autowired
    private ComponentRepository componentRepository;

    public void run(ApplicationArguments args) {
        menuRepository.deleteAll();
        menuRepository.save(new Menu(1L, "Home", "home", "home", 0));
        menuRepository.save(new Menu(2L, "Deployment", "paper-plane", "deployments", 0));
        menuRepository.save(new Menu(3L, "Dictionary", "book", "dictionary", 0));
        menuRepository.save(new Menu(4L, "Table", "th", "table", 0));
        menuRepository.save(new Menu(5L, "Post", "book", "posts", 0));
        menuRepository.save(new Menu(6L, "Admin", "user", "admin", 0));
        menuRepository.save(new Menu(7L, "Home", "home", "home", 0));
        menuRepository.save(new Menu(8L, "Deployment", "paper-plane", "deployments", 0));
        menuRepository.save(new Menu(9L, "Dictionary", "book", "dictionary", 0));
        menuRepository.save(new Menu(10L, "Table", "th", "table", 0));
        menuRepository.save(new Menu(11L, "Post", "book", "posts", 0));
        menuRepository.save(new Menu(12L, "Admin", "user", "admin", 0));

        deploymentRepository.deleteAll();
        componentRepository.deleteAll();
        Component musteriComponent = new Component("MMS Musteri");
        componentRepository.save(musteriComponent);

        Component customerComponent = new Component("CIF Customer");
        componentRepository.save(customerComponent);

        Component cmsComponent = new Component("CMS Util");
        componentRepository.save(cmsComponent);

        Component component = new Component("MMS Musteri");
        componentRepository.save(component);
        component = new Component("" +
                "");
        componentRepository.save(component);
        component = new Component("MMS Musteri3");
        componentRepository.save(component);
        component = new Component("MMS Musteri4");
        componentRepository.save(component);
        component = new Component("MMS Musteri");
        componentRepository.save(component);
        component = new Component("MMS Musteri");
        componentRepository.save(component);
        component = new Component("MMS Musteri");
        componentRepository.save(component);
        component = new Component("MMS Musteri");
        componentRepository.save(component);

        deploymentRepository.save(new Deployment(LocalDate.now(), musteriComponent, "Test"));
        deploymentRepository.save(new Deployment(LocalDate.now(), customerComponent, "PreProd"));
        deploymentRepository.save(new Deployment(LocalDate.now(), cmsComponent, "Prod"));
        deploymentRepository.save(new Deployment(LocalDate.now(), musteriComponent, "PreProd"));
    }
}