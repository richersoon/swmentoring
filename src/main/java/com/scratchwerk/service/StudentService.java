package com.scratchwerk.service;

import com.scratchwerk.dto.StudentDto;
import com.scratchwerk.dto.StudentRequestDto;
import com.scratchwerk.model.Student;
import com.scratchwerk.repo.StudentRepository;
import ma.glasnost.orika.MapperFacade;

import javax.inject.Inject;
import javax.inject.Named;
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
}
