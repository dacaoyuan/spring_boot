package com.example.girl.controller;

import com.example.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    /*@Value("${cubSize}")
    private String cubSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;*/


    @Autowired
    private GirlProperties properties;


    //@RequestMapping(value = "/say", method = RequestMethod.POST)
    @PostMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer ids) {
        //return cubSize + " " + age;
        //return properties.getCubSize();

        return "id=>>> " + ids;
    }


    /*@RequestMapping(value = "/say/{id}", method = RequestMethod.POST)
    public String say(@PathVariable("id") Integer ids) {
        //return cubSize + " " + age;
        //return properties.getCubSize();

        return "id=>>> " + ids;
    }*/
}
