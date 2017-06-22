package com.cipil.first.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by Dinco-WORK on 21.06.2017.
 */
@Data
public class ProfileDTO {
    Long profileId;
    String profileFirstName;
    List<String> addressListValue;
}
