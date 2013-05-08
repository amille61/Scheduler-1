package schedulerview.ycp.edu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import scheduler.ycp.edu.shared.Course;


public class CourseTest {
	private String test_num;
	private int test_CRNNum;
	private String test_name;
	private int test_credit;
	private String test_days;
	private double test_startTime;
	private double test_endTime;
	private String test_instructor;
	private String test_room;
	private Course course;
	
	@Before
	public void setUp() throws Exception {
		test_num = "CS101";
		test_CRNNum = 123456;
		test_name = "Computer Science Class";
		test_credit = 2;
		test_days = "TR";
		test_startTime = 8;
		test_endTime = 9;
		test_instructor = "Babcock";
		test_room = "KEC 123";
		course = new Course("", 0, "", 0, "", 0, 0, "", "");
	}
	
	@Test
	public void testsetNum() throws Exception {
		course.setNum(test_num);
		assertEquals("CS101", course.getNum());
	}

}
