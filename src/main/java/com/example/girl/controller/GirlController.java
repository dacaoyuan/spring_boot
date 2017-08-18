package com.example.girl.controller;


import com.example.girl.aspect.HttpAspect;
import com.example.girl.domain.Girl;
import com.example.girl.service.GirlService;
import com.example.girl.repository.GirlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService service;


    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        logger.info("GirlController.girlList");
        List<Girl> all = girlRepository.findAll();
        return all;
    }

    @PostMapping(value = "/girls")
    public Girl girlAdd(@Valid Girl girls, BindingResult bindingResult) {//
        if (bindingResult.hasErrors()) {
            System.out.println("GirlController.girlAdd  " + bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        /*if (!(girls.getAge() >= 18)) {
            System.out.println("GirlController.girlAdd  dddddd");
            return null;
        }*/

        Girl girl = new Girl();
        girl.setAge(girls.getAge());
        girl.setCubSize(girls.getCubSize());

        return girlRepository.save(girl);
    }

    /*@PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cubSize") String cubSize, @RequestParam("age") Integer age) {

        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCubSize(cubSize);

        return girlRepository.save(girl);
    }*/


    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }


    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age) {
        List<Girl> ageList = girlRepository.findByAge(age);
        return ageList;
    }


    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cubSize") String cubSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCubSize(cubSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }


    @DeleteMapping(value = "/girls/{id}")
    public String girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
        System.out.println("GirlController.girlDelete");
        return "girl delete succeed!";
    }


    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        service.insertTwo();
    }
}