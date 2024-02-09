package com.sntzrr.services;

import com.sntzrr.repositories.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl {

    @Autowired
    private final IPersonRepository iPersonRepository;

    public void deletePerson(String id){
        this.iPersonRepository.deleteById(id);
    }
}
