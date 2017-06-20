package com.cipil.first.repository;


import com.cipil.first.model.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
/**
 * Created by dinco on 20.6.2017.
 */
public interface ProfileRepository extends CrudRepository<Profile, Long> {
    List<Profile> findByLastName(String lastName);
}