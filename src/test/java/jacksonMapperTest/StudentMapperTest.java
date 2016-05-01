package jacksonMapperTest;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;

import json.JsonFactory;
import service.student.Address;
import service.student.Student;
import service.student.PassedSubject;

public class StudentMapperTest {

	private JsonFactory jsonFactory = new JsonFactory();
	private Student student;
	private String jsonStudent =  "{"
			+ "\"firstname\": \"Richard\","
			+ "\"lastname\": \"Starks\","
			+ "\"age\": 25,"
			+ "\"id_card\": 42424242,"
			+ "\"address\": {"
							+ "\"street\": \"Wallaby\","
							+ "\"code\": 42,"
							+ "\"state\": \"Eurasia\""
							+"},"
			+ "\"passed_subjects\": ["
										+ "{"
											+ "\"name\": \"PDEP\","
											+ "\"year\": 2016,"
											+ "\"mark\": 10"
										+  "}"
									+ "],"
			+ "\"extra_property\": \"Does not fail because mapper is configured to not fail with unknown properties\""
			+ "}";
	
	@Before
	public void setUp() {
		student = jsonFactory.fromJson(jsonStudent,new TypeReference<Student>() {
		});
	}
	
	
	@Test
	public void studentBasicMappertest() {
		assertEquals(student.getAge(), 25);
		assertEquals(student.getFirstname(),"Richard");
		assertEquals(student.getIdCard(),42424242);
		assertEquals(student.getLastname(),"Starks");
		
	}
	
	
	@Test
	public void studentAddressMappertest() {
		Address studentAddress = student.getAddress();
		
		assertEquals(studentAddress.getCode(), 42 );
		assertEquals(studentAddress.getStreet(),"Wallaby");
		assertEquals(studentAddress.getState(),"Eurasia");
		
	}
	
	
	@Test
	public void studentPassedSubjectsMappertest() {
		List<PassedSubject> passedSubjects = student.getPassedSubjects();
		assertEquals(passedSubjects.size(), 1);
		
		PassedSubject pdep = passedSubjects.get(0);
		assertEquals(pdep.getName(),"PDEP");
		assertEquals(pdep.getYear(),2016);
		assertEquals(pdep.getMark(),10);
		
	}

}
