package org.starrier.sky.ladder.data.mongodb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author starrier
 * @date 2020/12/3
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "student")
public class Student {

    @Id
    private Long id;

    private String name;

    private Long age;

}
