package com.thymeleafcrud.demoapp.service;

import com.thymeleafcrud.demoapp.model.Test;

import java.util.List;
import java.util.Optional;

public interface TestService {

    List<Test> getAllTests();
    Test saveTest(Test test);

    Optional<Test> findTestById(long id);
}
