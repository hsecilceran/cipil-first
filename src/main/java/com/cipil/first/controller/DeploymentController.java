package com.cipil.first.controller;

import com.cipil.first.dto.DeploymentDTO;
import com.cipil.first.model.Deployment;
import com.cipil.first.repository.DeploymentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Dinco-WORK on 23.06.2017.
 */
@RestController
@RequestMapping("/deployments")
public class DeploymentController {

    @Autowired
    DeploymentRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public ResponseEntity<DeploymentDTO> createDeployment(@RequestBody DeploymentDTO deploymentDTO) {
        Deployment deployment = modelMapper.map(deploymentDTO, Deployment.class);
        deployment.setDate(LocalDate.now());
        repository.save(deployment);
        deploymentDTO.setId(deployment.getId());
        return new ResponseEntity<DeploymentDTO>(deploymentDTO, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    ResponseEntity<DeploymentDTO> getDeployment(@PathVariable String id,
                                             HttpServletResponse response) {
        if(!id.chars().allMatch( Character::isDigit ))
            return null;
        response.setHeader("Access-Control-Expose-Headers", "Content-Range");
        response.setHeader("Content-Range", "1");
        Deployment deployment = repository.findOne(Long.parseLong(id));
        if(deployment == null)
            return null;
        DeploymentDTO deploymentDTO = modelMapper.map(deployment, DeploymentDTO.class);
        return new ResponseEntity<DeploymentDTO>(deploymentDTO, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<DeploymentDTO> editDeployment(@RequestBody DeploymentDTO deploymentDTO) {
        Deployment deployment = modelMapper.map(deploymentDTO, Deployment.class);
        deployment.setDate(LocalDate.now());
        repository.save(deployment);
        return new ResponseEntity<DeploymentDTO>(deploymentDTO, HttpStatus.OK);
    }

    @RequestMapping
    List<DeploymentDTO> getDeployments(
            @RequestParam String sort,
            @RequestParam String range,
            @RequestParam String filter,
            HttpServletResponse response
    ){
        Iterable<Deployment> deployments = repository.findAll();

        Type targetListType = new TypeToken<List<DeploymentDTO>>() {}.getType();
        List<DeploymentDTO> deploymentDTOs = modelMapper.map(deployments, targetListType);
        response.setHeader("Access-Control-Expose-Headers", "Content-Range");
        response.setHeader("Content-Range", String.valueOf(deploymentDTOs.size()));
        return deploymentDTOs;
    }
}
