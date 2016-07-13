package com.scratchwerk.service;

import com.scratchwerk.dto.StudentDto;
import com.scratchwerk.model.Student;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.ConfigurableMapper;

import javax.inject.Named;
import java.time.LocalDateTime;

/**
 * Created by richersoon on 7/13/16.
 */
@Named
public class MappingConfigurer extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.getConverterFactory().registerConverter(new PassThroughConverter(LocalDateTime.class));
        factory
            .classMap(Student.class, StudentDto.class)
            .field("address.number", "number")
            .field("address.address1", "address1")
            .field("address.address2", "address2")
            .field("address.city", "city")
            .field("address.state", "state")
            .field("address.zip", "zip")
            .byDefault()
            .register();

    }

}
