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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {SwmentoringApplication.class, MongoDbConfig.class})
public class SwmentoringApplicationTests {

    @Inject
    private MongoTemplate mongoTemplate;

    @Inject
    private StudentService unitUnderTest;

    private Student initStudent;
    private StudentRequestDto initStudentRequest;

    @Before
    public void setUp() {
        mongoTemplate.dropCollection(Student.class);

        initStudentRequest = newStudentRequestDto();

        this.initStudent = Student.create(initStudentRequest);
        mongoTemplate.insert(this.initStudent);
    }

    @Test
    public void createSuccessfully() {
        final StudentRequestDto expected = new StudentRequestDto();
        final StudentDto actual = unitUnderTest.create(expected);

        assertNotNull(actual.getId());
        assertEquals(expected.getMentorId(), actual.getMentorId());
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getSuffix(), actual.getSuffix());
        assertEquals(expected.getPassword(), actual.getPassword());
        assertEquals(expected.getDob(), actual.getDob());
        assertEquals(expected.getSchool(), actual.getSchool());
        assertEquals(expected.getGrade(), actual.getGrade());
        assertEquals(expected.getTasks(), actual.getTasks());
        assertEquals(expected.getReportCards(), actual.getReportCards());
        assertEquals(expected.getProgressReports(), actual.getProgressReports());
        assertEquals(expected.getFatherId(), actual.getFatherId());
        assertEquals(expected.getMotherId(), actual.getMotherId());
        assertEquals(expected.getGuardianId1(), actual.getGuardianId1());
        assertEquals(expected.getGuardianId2(), actual.getGuardianId2());
        assertEquals(expected.getNumber(), actual.getNumber());
        assertEquals(expected.getAddress1(), actual.getAddress1());
        assertEquals(expected.getAddress2(), actual.getAddress2());
        assertEquals(expected.getCity(), actual.getCity());
        assertEquals(expected.getState(), actual.getState());
        assertEquals(expected.getZip(), actual.getZip());
    }

    @Test
	public void getSuccessfully() {
        final StudentDto actual = unitUnderTest.get(initStudent.getId().toHexString());
        assertEquals(initStudent.getId(), actual.getId());
        assertEquals(initStudent.getMentorId(), actual.getMentorId());
        assertEquals(initStudent.getFirstName(), actual.getFirstName());
        assertEquals(initStudent.getLastName(), actual.getLastName());
        assertEquals(initStudent.getEmail(), actual.getEmail());
        assertEquals(initStudent.getSuffix(), actual.getSuffix());
        assertEquals(initStudent.getPassword(), actual.getPassword());
        assertEquals(initStudent.getDob(), actual.getDob());
        assertEquals(initStudent.getSchool(), actual.getSchool());
        assertEquals(initStudent.getGrade(), actual.getGrade());
        assertEquals(initStudent.getTasks(), actual.getTasks());
        assertEquals(initStudent.getReportCards(), actual.getReportCards());
        assertEquals(initStudent.getProgressReports(), actual.getProgressReports());
        assertEquals(initStudent.getFatherId(), actual.getFatherId());
        assertEquals(initStudent.getMotherId(), actual.getMotherId());
        assertEquals(initStudent.getGuardianId1(), actual.getGuardianId1());
        assertEquals(initStudent.getGuardianId2(), actual.getGuardianId2());
        assertEquals(initStudent.getAddress().getNumber(), actual.getNumber());
        assertEquals(initStudent.getAddress().getAddress1(), actual.getAddress1());
        assertEquals(initStudent.getAddress().getAddress2(), actual.getAddress2());
        assertEquals(initStudent.getAddress().getCity(), actual.getCity());
        assertEquals(initStudent.getAddress().getState(), actual.getState());
        assertEquals(initStudent.getAddress().getZip(), actual.getZip());
    }

    @Test(expected = NullPointerException.class)
    public void getShouldThrowExceptionWhenStudentIdNotFound() {
        final StudentDto actual = unitUnderTest.get("DUMMY");
        assertNull(actual);
    }

    @Test
    public void updateSuccessfully() {
        initStudentRequest.setId(initStudent.getId().toHexString());
        initStudentRequest.setFirstName("Updated John");

        final StudentDto actual = unitUnderTest.update(initStudentRequest);
        assertEquals(initStudent.getId(), actual.getId());
        assertEquals(initStudent.getMentorId(), actual.getMentorId());

        assertEquals(initStudentRequest.getFirstName(), actual.getFirstName());

        assertEquals(initStudent.getLastName(), actual.getLastName());
        assertEquals(initStudent.getEmail(), actual.getEmail());
        assertEquals(initStudent.getSuffix(), actual.getSuffix());
        assertEquals(initStudent.getPassword(), actual.getPassword());
        assertEquals(initStudent.getDob(), actual.getDob());
        assertEquals(initStudent.getSchool(), actual.getSchool());
        assertEquals(initStudent.getGrade(), actual.getGrade());
        assertEquals(initStudent.getTasks(), actual.getTasks());
        assertEquals(initStudent.getReportCards(), actual.getReportCards());
        assertEquals(initStudent.getProgressReports(), actual.getProgressReports());
        assertEquals(initStudent.getFatherId(), actual.getFatherId());
        assertEquals(initStudent.getMotherId(), actual.getMotherId());
        assertEquals(initStudent.getGuardianId1(), actual.getGuardianId1());
        assertEquals(initStudent.getGuardianId2(), actual.getGuardianId2());
        assertEquals(initStudent.getAddress().getNumber(), actual.getNumber());
        assertEquals(initStudent.getAddress().getAddress1(), actual.getAddress1());
        assertEquals(initStudent.getAddress().getAddress2(), actual.getAddress2());
        assertEquals(initStudent.getAddress().getCity(), actual.getCity());
        assertEquals(initStudent.getAddress().getState(), actual.getState());
        assertEquals(initStudent.getAddress().getZip(), actual.getZip());
    }

    @Test(expected = NullPointerException.class)
    public void updateShouldThrowExceptionWhenStudentNotFound() {
        initStudentRequest.setId("Dummy");

        unitUnderTest.update(initStudentRequest);
    }

    @Test
    public void deleteSuccessfully() {
        unitUnderTest.delete(initStudent.getId().toHexString());
    }

    @Test(expected = NullPointerException.class)
    public void deleteShouldThrowExceptionWhenStudentNotFound() {
        unitUnderTest.delete(initStudent.getId().toHexString());
        unitUnderTest.delete(initStudent.getId().toHexString());
    }

    private StudentRequestDto newStudentRequestDto() {
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
        return studentRequest;
    }
}
