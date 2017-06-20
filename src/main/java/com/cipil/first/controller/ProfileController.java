package com.cipil.first.controller;
import com.cipil.first.model.Profile;
import com.cipil.first.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dinco on 20.6.2017.
 */
@RestController
public class ProfileController {
    @Autowired
    ProfileRepository repository;

    @RequestMapping("/save")
    public String process(){
        repository.save(new Profile("Jack", "Smith"));
        repository.save(new Profile("Adam", "Johnson"));
        repository.save(new Profile("Kim", "Smith"));
        repository.save(new Profile("David", "Williams"));
        repository.save(new Profile("Peter", "Davis"));
        return "Done";
    }


    @RequestMapping("/findall")
    public String findAll(){
        String result = "<html>";

        for(Profile cust : repository.findAll()){
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "<html>";

        for(Profile cust: repository.findByLastName(lastName)){
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }
}
