package com.example.girl.service;

import com.example.girl.domain.Girl;
import com.example.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(22);
        girlA.setCubSize("D");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(24);
        girlB.setCubSize("F");
        girlRepository.save(girlB);

    }

}
