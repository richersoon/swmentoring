package com.scratchwerk.controller;

import com.scratchwerk.dto.StudentDto;
import com.scratchwerk.dto.StudentRequestDto;
import com.scratchwerk.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by richersoon on 7/14/16.
 */
@Controller
public class StudentController {

    @Inject
    private StudentService studentService;

    @RequestMapping(value="/students", params = "register")
    public String createForm(StudentRequestDto student) {
        return "students/create";
    }

    @RequestMapping(value="/students/create", method = RequestMethod.POST)
    public String create(StudentRequestDto student) {
        final StudentDto studentDto = studentService.create(student);
        return "redirect:/students/" + studentDto.getId();
    }

    @RequestMapping(value="/students/{id}", method = RequestMethod.GET)
    public String create(@PathVariable String id, Map<String, Object> model) {
        final StudentDto studentDto = studentService.get(id);
        model.put("student", studentDto);
        return "students/view";
    }
}
