package com.scratchwerk.service;

import com.scratchwerk.dto.StudentDto;
import com.scratchwerk.model.Student;
import com.scratchwerk.repo.StudentRepository;
import ma.glasnost.orika.MapperFacade;

import javax.inject.Inject;
import javax.inject.Named;

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

    public StudentDto get(String id) {
        final Student student = studentRepository.findOne(id);
        final StudentDto dto = mapperFacade.map(student, StudentDto.class);
        return dto;
    }
}
