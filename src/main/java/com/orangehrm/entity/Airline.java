package com.orangehrm.entity;

import com.orangehrm.enums.RandomDataTypeNames;
import com.orangehrm.utils.DateUtils;
import com.orangehrm.utils.RandomDataGenerator;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Airline {

    //private String gender = Stream.of("male","female","others").findAny().get();
    //private Gender gender = Arrays.stream(Gender.values()).findAny().get();
    @Builder.Default
    private int id = Integer.parseInt(RandomDataGenerator.getRandomNumber(6));

    private String idValue;
    private String name = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME);
    private String country = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.COUNTRY);
    private String logo = RandomDataGenerator.getRandomAlphabets(25);
    private String slogan = RandomDataGenerator.getRandomAlphabets(20);
    private String head_quarters = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CITYNAME);
    private String website = RandomDataGenerator.getRandomWebsiteName();
    private String established = String.valueOf(RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentYear()));
}
