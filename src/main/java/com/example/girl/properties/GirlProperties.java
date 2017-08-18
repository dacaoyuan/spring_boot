package com.example.girl.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {

    private String cubSize;
    private Integer age;

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
}
