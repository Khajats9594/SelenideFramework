package com.orangehrm.entity;

import com.orangehrm.pages.strategy.FirstNameStrategy;
import com.orangehrm.pages.strategy.LastNameStrategy;
import com.orangehrm.pages.strategy.MiddleNameStrategy;
import lombok.Builder;
import lombok.Data;
import uk.co.jemos.podam.common.PodamStrategyValue;
import uk.co.jemos.podam.common.PodamStringValue;

@Data
@Builder(toBuilder = true)
public class EmployeeDetails {
    @PodamStrategyValue(FirstNameStrategy.class)
    private String firstName;
    @PodamStrategyValue(LastNameStrategy.class)
    private String lastName;
    @PodamStrategyValue(MiddleNameStrategy.class)
    private String middleName;
    @PodamStringValue(strValue = "images/testImage.jpeg")
    private String profilePicturePath;
}
