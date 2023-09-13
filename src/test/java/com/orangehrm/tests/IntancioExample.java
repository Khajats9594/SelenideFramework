package com.orangehrm.tests;

import com.orangehrm.entity.Airline;
import com.orangehrm.entity.EmployeeDetails;
import com.orangehrm.entity.Student;
import com.orangehrm.testdata.EmployeeTestData;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.instancio.Instancio;
import org.instancio.Select;
import java.util.Arrays;
import java.util.Set;

public class IntancioExample {

    public static void main(String[] args) throws JsonProcessingException {
        Airline airline = Airline.builder().build();
        System.out.println(airline);

        System.out.println("................................................");

        Airline airline1 = new Airline().toBuilder().build();
        System.out.println(airline1);

        System.out.println("................................................");

        Airline airline2 = Airline.builder().country("India").build();
        System.out.println(airline2);

        System.out.println("................................................");

        EmployeeDetails employeeDetails = EmployeeTestData.getRandomEmployeeDetails();
        System.out.println(employeeDetails);

        System.out.println("................................................");

        Student createAirline = Instancio.create(Student.class);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(createAirline));

        System.out.println(".......................................................................");

        Set<Student> list = Instancio.ofSet(Student.class).size(10).create();
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(list));

        System.out.println(".......................................................................");

        Student ss = Instancio.of(Student.class)
                //.ignore(Select.field("logo"))
                .generate(Select.field("id"), gen -> gen.ints().range(18, 65))
                .generate(Select.field("established"), gen -> gen.oneOf(Arrays.asList("abc","Def")))
                .generate(Select.field("established"), gen -> gen.temporal().localDateTime().past().asString())
                .generate(Select.field("name"), gen -> gen.text().pattern("#d#d#d-#d#d-#d#d"))
                .lenient()
                .create();

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(ss));

        System.out.println(".......................................................................");

        Student ss1 = Instancio.of(Student.class)
                //.ignore(Select.field("slogan"))
                .ignore(Select.field(Airline.class, "country"))
                .lenient()
                .create();

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(ss1));


    }
}
