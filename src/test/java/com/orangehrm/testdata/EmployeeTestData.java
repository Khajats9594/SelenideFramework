package com.orangehrm.testdata;

import com.orangehrm.entity.EmployeeDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public final class EmployeeTestData {

    private EmployeeTestData(){}
    private static final Logger logger = LogManager.getLogger(EmployeeTestData.class);
    public static EmployeeDetails getRandomEmployeeDetails(){
        logger.info("PodamFactory:manufacturingPojo of EmployeeDetails.class");
        return new PodamFactoryImpl().manufacturePojo(EmployeeDetails.class);
    }

}
