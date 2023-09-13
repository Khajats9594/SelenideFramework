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
    @Builder.Default
    private String name = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME);
    @Builder.Default
    private String country = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.COUNTRY);
    @Builder.Default
    private String logo = RandomDataGenerator.getRandomAlphabets(25);
    @Builder.Default
    private String slogan = RandomDataGenerator.getRandomAlphabets(20);
    @Builder.Default
    private String head_quarters = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CITYNAME);
    @Builder.Default
    private String website = RandomDataGenerator.getRandomWebsiteName();
    @Builder.Default
    private String established = String.valueOf(RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentYear()));
}
