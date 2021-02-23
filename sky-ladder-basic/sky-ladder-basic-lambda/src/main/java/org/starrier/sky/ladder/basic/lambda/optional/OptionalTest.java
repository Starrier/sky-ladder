package org.starrier.sky.ladder.basic.lambda.optional;

import org.starrier.sky.ladder.basic.entity.Student;
import org.starrier.sky.ladder.basic.entity.factory.StudentFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author starrier
 * @date 2021/1/5
 */
public class OptionalTest {

    public static void testOrElseAndOrElseGet() {
        Optional<String> of = Optional.of("test-of");

        System.out.println(of.orElse("1"));
        System.out.println(of.orElseGet(() -> String.valueOf(2)));

        Optional<String> ofNullable = Optional.ofNullable("test-of-nullable");
        System.out.println(ofNullable.orElse(ofNullable.get()));
        System.out.println(ofNullable.orElseGet(() -> String.valueOf(ofNullable)));


    }


    public static void test() {
        List<Student> studentList = StudentFactory.createListA();

        List<Student> students = new ArrayList<>();

        //1
        Integer integer = Optional.ofNullable(
                studentList
                        .stream()
                        .map(Student::getAge)
                        .collect(Collectors.toList())
                        .get(0))
                .orElse(null);

        System.out.println(integer);

        // Exception
        Integer testFilter = students.stream()
                .filter(Objects::nonNull)
                .map(Student::getAge)
                .collect(Collectors.toList())
                .get(0);
        System.out.println(testFilter);

        // Exception
        Integer testNull = Optional.ofNullable(
                students
                        .stream()
                        .map(Student::getAge)
                        .collect(Collectors.toList())
                        .get(0))
                .orElseGet(null);

        System.out.println(testNull);
    }

    public static void testWithOf() {
        // -----------     both source and alternative have value  ----------------------
        String haveValue = "source-have-value";
        String testHaveValue = Optional.of(haveValue).orElse("alternative-value");
        // assert value is source-have-value
        System.out.println(testHaveValue);
        String testHaveValueOrElseGet = Optional.of(haveValue).orElseGet(() -> "alternative-value");
        // assert value is source-have-value
        System.out.println(testHaveValueOrElseGet);

        //  ---------    source is  blank, and alternative has value
        String haveNoValue = "";
        String testHaveNoValue = Optional.of(haveNoValue).orElse("alternative-value");
        // assert value is "alternative-value"
        System.out.println(testHaveNoValue);

        String testHaveNoValueOrElseGet = Optional.of(haveNoValue).orElseGet(()->"alternative-value");
        // assert value is "alternative-value"
        System.out.println(testHaveNoValueOrElseGet);

        // ------------  both source and alternative null
        String haveValueNull =null;
        String doubleNullOrElse = Optional.ofNullable(haveValueNull).orElse(null);
        // assert null
        System.out.println(doubleNullOrElse);


        String doubleNullOrElseGet = Optional.ofNullable(haveValueNull).orElseGet(() -> null);
        // assert npe
        System.out.println(doubleNullOrElseGet);


    }


    public static String getDefaultValue(){
        System.out.println("invoke");
        return "default-value";
    }

    public static void testOrders(){
        Optional<String> optional = Optional.of("source-value");

        String x = optional.orElse(getDefaultValue());
        System.out.println(x);
        System.out.println("----------");
        String y =  optional.orElseGet(OptionalTest::getDefaultValue);
        System.out.println(y);
    }

    public static int  passValue(){
        System.out.println("pass function");
        return 1;
    }

    public static int returnValue(int a){
        System.out.println("return a");
        return a;
    }

    public static void main(String[] args) {
        testOrders();
    }

}
