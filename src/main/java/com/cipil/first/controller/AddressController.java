package com.cipil.first.controller;
import com.cipil.first.model.Address;
import com.cipil.first.model.Profile;
import com.cipil.first.repository.AddressRepository;
import com.cipil.first.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinco on 20.6.2017.
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressRepository repository;


    @RequestMapping("/findall")
    @ResponseBody
    public List<Address> findAll(){

        List<Address> returnValue = new ArrayList<Address>();
        for(Address address : repository.findAll()){
            returnValue.add(address);
        }

        return returnValue;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }

    @RequestMapping("/findbyprofile")
    @ResponseBody
    public List<Address> fetchDataByProfile(@RequestParam("profileId") Long profileId){
        List<Address> response = repository.findByProfileId(profileId);
        return response;
    }
}
