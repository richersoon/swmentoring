package com.scratchwerk.mentoring;

import com.scratchwerk.SwmentoringApplication;
import com.scratchwerk.dto.StudentDto;
import com.scratchwerk.dto.StudentRequestDto;
import com.scratchwerk.model.Student;
import com.scratchwerk.service.StudentService;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {SwmentoringApplication.class, MongoDbConfig.class})
public class SwmentoringApplicationTests {

    @Inject
    private MongoTemplate mongoTemplate;

    @Inject
    private StudentService unitUnderTest;

    private Student student;

    @Before
    public void setUp() {
        mongoTemplate.dropCollection(Student.class);

        final StudentRequestDto studentRequest = new StudentRequestDto();
        studentRequest.setMentorId(new ObjectId().toHexString());
        studentRequest.setFirstName("John");
        studentRequest.setLastName("Smith");
        studentRequest.setEmail("johnsmith@gmail.com");
        studentRequest.setSuffix("Sr");
        studentRequest.setPassword("testpassword");
        studentRequest.setDob(LocalDateTime.now());
        studentRequest.setSchool("Harvard");
        studentRequest.setGrade(98);
        studentRequest.setTasks(Arrays.asList("1","2"));
        studentRequest.setReportCards(Arrays.asList("3","4"));
        studentRequest.setProgressReports(Arrays.asList("5","6"));
        studentRequest.setFatherId(new ObjectId().toHexString());
        studentRequest.setMotherId(new ObjectId().toHexString());
        studentRequest.setGuardianId1(new ObjectId().toHexString());
        studentRequest.setGuardianId2(new ObjectId().toHexString());
        studentRequest.setNumber("639361234567");
        studentRequest.setAddress1("New York");
        studentRequest.setAddress2("New Jersey");
        studentRequest.setCity("New York City");
        studentRequest.setState("New York State");
        studentRequest.setZip(11762);

        this.student = Student.create(studentRequest);
        mongoTemplate.insert(this.student);
    }

	@Test
	public void getSuccessfully() {
        final StudentDto actual = unitUnderTest.get(student.getId().toHexString());
        assertEquals(student.getId(), actual.getId());
        assertEquals(student.getMentorId(), actual.getMentorId());
        assertEquals(student.getFirstName(), actual.getFirstName());
        assertEquals(student.getLastName(), actual.getLastName());
        assertEquals(student.getEmail(), actual.getEmail());
        assertEquals(student.getSuffix(), actual.getSuffix());
        assertEquals(student.getPassword(), actual.getPassword());
        assertEquals(student.getDob(), actual.getDob());
        assertEquals(student.getSchool(), actual.getSchool());
        assertEquals(student.getGrade(), actual.getGrade());
        assertEquals(student.getTasks(), actual.getTasks());
        assertEquals(student.getReportCards(), actual.getReportCards());
        assertEquals(student.getProgressReports(), actual.getProgressReports());
        assertEquals(student.getFatherId(), actual.getFatherId());
        assertEquals(student.getMotherId(), actual.getMotherId());
        assertEquals(student.getGuardianId1(), actual.getGuardianId1());
        assertEquals(student.getGuardianId2(), actual.getGuardianId2());
        assertEquals(student.getAddress().getNumber(), actual.getNumber());
        assertEquals(student.getAddress().getAddress1(), actual.getAddress1());
        assertEquals(student.getAddress().getAddress2(), actual.getAddress2());
        assertEquals(student.getAddress().getCity(), actual.getCity());
        assertEquals(student.getAddress().getState(), actual.getState());
        assertEquals(student.getAddress().getZip(), actual.getZip());
    }

    @Test
    public void getShouldReturnNullWhenStudentIdNotFound() {
        final StudentDto actual = unitUnderTest.get("DUMMY");
        assertNull(actual);
    }
}
