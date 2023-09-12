package com.orangehrm.testdata;

import com.orangehrm.entity.LoginDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public final class LoginTestData {

    private LoginTestData(){}
    private static final Logger logger = LogManager.getLogger(LoginTestData.class);
    public static LoginDetails getValidLoginDetails(){
        logger.info("PodamFactory:manufacturingPojo of LoginDetails.class");
        return new PodamFactoryImpl().manufacturePojo(LoginDetails.class);
    }
}
