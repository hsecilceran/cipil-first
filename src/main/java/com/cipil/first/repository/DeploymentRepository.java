package com.cipil.first.repository;

import com.cipil.first.model.Deployment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;


/**
 * Created by Dinco-WORK on 23.06.2017.
 */
public interface DeploymentRepository extends CrudRepository<Deployment, Long> {
}
