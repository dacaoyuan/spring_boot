package com.example.girl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private String cubSize;

    @Min(value = 18, message = "未成年")
    private Integer age;


    public Girl() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCubSize() {
        return cubSize;
    }

    public void setCubSize(String cubSize) {
        this.cubSize = cubSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Girl{" +
                "cubSize='" + cubSize + '\'' +
                ", age=" + age +
                '}';
    }
}
