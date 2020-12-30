package org.starrier.sky.ladder.basic.lambda;

import org.apache.commons.collections4.CollectionUtils;
import org.starrier.sky.ladder.basic.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author starrier
 * @date 2020/12/30
 */
public class StudentFactoryConvert {

    public static List<Integer> studentsConvertParaller(List<Student> students){

        if(CollectionUtils.isEmpty(students)){
            return new ArrayList<>();
        }

        return students.stream().parallel()
                .map(StudentFactoryConvert::studentConvert)
                .distinct()
                .collect(Collectors.toList());


    }

    public static List<Integer> studentsConvert(List<Student> students){

        if(CollectionUtils.isEmpty(students)){
            return new ArrayList<>();
        }

        return students.stream()
                .map(StudentFactoryConvert::studentConvert)
                .distinct()
                .collect(Collectors.toList());


    }

    public static Integer studentConvert(Student student){

        if(Objects.isNull(student)){
            return 0;
        }

        return student.getAge();
    }
}
