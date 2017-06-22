package com.cipil.first.controller;
import com.cipil.first.dto.ProfileDTO;
import com.cipil.first.model.Address;
import com.cipil.first.model.Profile;
import com.cipil.first.repository.AddressRepository;
import com.cipil.first.repository.ProfileRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    AddressRepository addressRepository;

    @RequestMapping("/save")
    public String process(){
        profileRepository.deleteAll();
        addressRepository.deleteAll();

        Profile p = new Profile("Jack", "Smith");
        profileRepository.save(p);
        Address a = new Address("Adres Jack", p);
        addressRepository.save(a);

        p = new Profile("Çipil", "Özdemir");
        profileRepository.save(p);
        a = new Address("Adres Özdemir", p);
        addressRepository.save(a);

        p = new Profile("Dinç", "Özdemir");
        profileRepository.save(p);
        a = new Address("Adres 1 Özdemir", p);
        addressRepository.save(a);

        p = new Profile("Kubilay", "Kara");
        profileRepository.save(p);
        a = new Address("Adres Kubilay", p);
        addressRepository.save(a);

        p = new Profile("Murat", "Ayık");
        profileRepository.save(p);
        a = new Address("Adres Ayık", p);
        addressRepository.save(a);
        a = new Address("Adres Ayık2", p);
        addressRepository.save(a);
        a = new Address("Adres Ayık3", p);
        addressRepository.save(a);

        return "Done";
    }


    @RequestMapping("/findall")
    @ResponseBody
    public List<ProfileDTO> findAll(){
        Iterable<Profile> profiles = profileRepository.findAll();
        ModelMapper mapper = new ModelMapper();
        ProfileDTO orderDTO = mapper.map(profiles.iterator().next(), ProfileDTO.class);
        java.lang.reflect.Type targetListType = new TypeToken<List<ProfileDTO>>() {}.getType();
        List<ProfileDTO> personDTOs = mapper.map(profiles, targetListType);
        return personDTOs;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = profileRepository.findOne(id).toString();
        return result;
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "<html>";

        for(Profile cust: profileRepository.findByLastName(lastName)){
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }
}
