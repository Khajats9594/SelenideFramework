package com.orangehrm.entity;

import lombok.Data;
import uk.co.jemos.podam.common.PodamStringValue;

@Data
public class EmployeeDetails {

    private String firstName;
    private String lastName;
    private String middleName;
    @PodamStringValue(strValue = "images/testImage.jpeg")
    private String profilePicturePath;
}