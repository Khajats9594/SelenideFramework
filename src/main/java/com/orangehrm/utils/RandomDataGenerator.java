package com.orangehrm.utils;

import com.orangehrm.enums.RandomDataType;
import net.datafaker.Faker;

public class RandomDataGenerator {

    private static final Faker faker = new Faker();
    public static String getRandomFirstName(RandomDataType dataTypeName){
        return faker.name().firstName();
    }
    public static String getRandomLastName(RandomDataType dataTypeName){
        return faker.name().lastName();
    }
    public static String getRandomMiddleName(RandomDataType dataTypeName){
        return faker.name().nameWithMiddle();
    }
    public static String getRandomCountyName(RandomDataType dataTypeName){
        return faker.address().country();
    }
    public static String getRandomCityName(RandomDataType dataTypeName){
        return faker.address().cityName();
    }
}
