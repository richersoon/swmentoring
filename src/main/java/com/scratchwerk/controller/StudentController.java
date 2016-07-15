package com.scratchwerk.controller;

import com.scratchwerk.dto.StudentDto;
import com.scratchwerk.dto.StudentRequestDto;
import com.scratchwerk.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by richersoon on 7/14/16.
 */
@Controller
public class StudentController {

    @Inject
    private StudentService studentService;

    @RequestMapping(value="/students/create")
    public String createForm(Model model) {
        return "students/create";
    }

    @RequestMapping(value="/students/{id}/update", method = RequestMethod.POST)
    public String updateForm(@PathVariable String id, Model model) {
        final StudentDto student = studentService.get(id);
        model.addAttribute("student", student);
        return "students/update";
    }

    @RequestMapping(value="/students", method = RequestMethod.POST)
    public String create(StudentRequestDto student) {
        final StudentDto studentDto = studentService.create(student);
        return "redirect:/students/" + studentDto.getId();
    }

    @RequestMapping(value="/students/{id}", method = RequestMethod.GET)
    public String get(@PathVariable String id, Map<String, Object> model) {
        final StudentDto studentDto = studentService.get(id);
        model.put("student", studentDto);
        return "students/view";
    }

    @RequestMapping(value="/students/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable String id, StudentRequestDto student) {
        studentService.update(student);
        return "redirect:/students/" + id;
    }

    @RequestMapping(value="/students/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable String id) {
        studentService.delete(id);
        return "Successfully deleted";
    }

    @ModelAttribute("allTasks")
    public List<String> allTasks() {
        return studentService.getTasks();
    }

    @ModelAttribute("allReportCards")
    public List<String> allReportCards() {
        return studentService.getReportCards();
    }

    @ModelAttribute("allProgressReports")
    public List<String> allProgressReports() {
        return studentService.getProgressReports();
    }
}
