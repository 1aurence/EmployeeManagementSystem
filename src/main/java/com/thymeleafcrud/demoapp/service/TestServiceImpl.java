package com.thymeleafcrud.demoapp.service;

import com.thymeleafcrud.demoapp.model.Test;
import com.thymeleafcrud.demoapp.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestRepository testRepository;


    @Override
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    @Override
    public Test saveTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Optional<Test> findTestById(long id) {
        return testRepository.findById(id);
    }
}
