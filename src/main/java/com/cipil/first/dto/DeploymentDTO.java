package com.cipil.first.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by Dinco-WORK on 23.06.2017.
 */
@Data
public class DeploymentDTO {

    Long id;
    String componentId;
    String componentName;
    String environment;
    LocalDate date;
}
