package com.thymeleafcrud.demoapp.controller;

import com.thymeleafcrud.demoapp.model.Test;
import com.thymeleafcrud.demoapp.repository.TestRepository;
import com.thymeleafcrud.demoapp.service.TestService;
import com.thymeleafcrud.demoapp.service.TestServiceImpl;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.Optional;

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/testing")
    public String viewHomePage(Model model) {
        Test test = new Test();
        model.addAttribute("test", test);
        return "test_form";
    }

    @GetMapping("/testing/test/{id}")
    public String getTestById(Model model, @PathVariable(name = "id") long id) {
        Test test = testService.findTestById(id);
        if (test != null) {
            model.addAttribute("test", test);
        } else {
            model.addAttribute("test_id", id);
            return "not_found";
        }
        return "test";
    }

    @PostMapping("/saveTest")
    public String saveTest(@ModelAttribute("test") Test test) {
        test.setCreatedAt(new Date());
        testService.saveTest(test);
        return "redirect:/";
    }
}
