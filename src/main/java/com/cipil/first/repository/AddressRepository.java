package com.cipil.first.repository;


import com.cipil.first.model.Address;
import com.cipil.first.model.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dinco on 20.6.2017.
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findByProfileId(Long profileId);
}