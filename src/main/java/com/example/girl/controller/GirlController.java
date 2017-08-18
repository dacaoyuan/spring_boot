package com.example.girl.controller;


import com.example.girl.domain.Girl;
import com.example.girl.domain.Result;
import com.example.girl.enums.ResultEnum;
import com.example.girl.service.GirlService;
import com.example.girl.repository.GirlRepository;
import com.example.girl.utils.ResultUtils;
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
    public Result<Girl> girlAdd(@Valid Girl girls, BindingResult bindingResult) {//
        Result<Girl> result;
        if (bindingResult.hasErrors()) {
            //System.out.println("GirlController.girlAdd  " + bindingResult.getFieldError().getDefaultMessage());
            result = ResultUtils.error(1, bindingResult.getFieldError().getDefaultMessage());

            return result;
        }

        /*if (!(girls.getAge() >= 18)) {
            System.out.println("GirlController.girlAdd  dddddd");
            return null;
        }*/

        Girl girl = new Girl();
        girl.setAge(girls.getAge());
        girl.setCubSize(girls.getCubSize());
        girlRepository.save(girl);

        result = ResultUtils.success(girl, ResultEnum.SUCCESS);


        return result;
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


    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        service.getAge(id);
    }


}
