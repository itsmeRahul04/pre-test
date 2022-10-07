package com.capgemini.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "employeeData")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class employee {

    @Id
    private long id;


    private String name;


    private String email;


    private String dept;

}
