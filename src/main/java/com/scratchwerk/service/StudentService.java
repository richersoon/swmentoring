package com.scratchwerk.service;

import com.scratchwerk.dto.StudentDto;
import com.scratchwerk.dto.StudentRequestDto;
import com.scratchwerk.model.Student;
import com.scratchwerk.repo.StudentRepository;
import ma.glasnost.orika.MapperFacade;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by richersoon on 7/12/16.
 */
@Named
public class StudentService {

    private MapperFacade mapperFacade;
    private StudentRepository studentRepository;

    @Inject
    public StudentService(StudentRepository studentRepository, MapperFacade mapperFacade) {
        this.studentRepository = studentRepository;
        this.mapperFacade = mapperFacade;
    }

    public StudentDto create(final StudentRequestDto requestDto) {
        Student student = Student.create(requestDto);
        student = studentRepository.insert(student);
        final StudentDto dto = mapperFacade.map(student, StudentDto.class);
        return dto;
    }

    public StudentDto get(final String id) {
        final Student student = studentRepository.findOne(id);

        Objects.requireNonNull(student);

        final StudentDto dto = mapperFacade.map(student, StudentDto.class);
        return dto;
    }

    public StudentDto update(final StudentRequestDto requestDto) {
        Student student = studentRepository.findOne(requestDto.getId());

        Objects.requireNonNull(student);

        student.update(requestDto);
        student = studentRepository.save(student);
        final StudentDto dto = mapperFacade.map(student, StudentDto.class);
        return dto;
    }

    public void delete(final String id) {
        Student student = studentRepository.findOne(id);

        Objects.requireNonNull(student);

        studentRepository.delete(id);
    }

    public List<String> getTasks() {
        List<String> tasks = Arrays.asList("Task 1", "Task 2", "Task 3", "Task 4");
        return tasks;
    }

    public List<String> getReportCards() {
        List<String> tasks = Arrays.asList("Report 1", "Report 2", "Report 3", "Report 4");
        return tasks;
    }

    public List<String> getProgressReports() {
        List<String> tasks = Arrays.asList("Progress Report 1", "Progress Report 2", "Progress Report 3", "Progress Report 4");
        return tasks;
    }
}
