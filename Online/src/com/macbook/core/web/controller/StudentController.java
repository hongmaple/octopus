package com.macbook.core.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

    @RequestMapping(value = "/toStudentFirst.action",method = RequestMethod.GET)
    public String toFirst(){
        return "Student/student_main";
    }
    @RequestMapping(value = "/toStudentAbout.action",method = RequestMethod.GET)
    public String toAbout(){
        return "Student/student_about";
    }
}
