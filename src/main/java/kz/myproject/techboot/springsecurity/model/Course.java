package kz.myproject.techboot.springsecurity.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "z_courses")
@Getter
@Setter
public class Course extends BaseModel{
    @Column(name = "name")
    private String name;
    @Column(name = "description",columnDefinition = "TEXT")
    private String description;
    @Column(name = "price")
    private BigInteger price;


}
