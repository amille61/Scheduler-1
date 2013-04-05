package scheduler.ycp.edu;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import scheduler.ycp.edu.shared.Course;
import scheduler.ycp.edu.shared.Generate;

public class GenerateTest {

	private Course course1 = new Course(null, 0, null, 0, null, 0, 0, null, null);
	private Course course2 = new Course(null, 0, null, 0, null, 0, 0, null, null);
	private Course course3 = new Course(null, 0, null, 0, null, 0, 0, null, null);
	private Course course4 = new Course(null, 0, null, 0, null, 0, 0, null, null);
	private Course course5 = new Course(null, 0, null, 0, null, 0, 0, null, null);
	private Course course6 = new Course(null, 0, null, 0, null, 0, 0, null, null);
	private Course course7 = new Course(null, 0, null, 0, null, 0, 0, null, null);

	private List<Course> scheduleM = new ArrayList<Course>();
	private List<Course> scheduleT = new ArrayList<Course>();
	private List<Course> scheduleW = new ArrayList<Course>();
	private List<Course> scheduleR = new ArrayList<Course>();
	private List<Course> scheduleF = new ArrayList<Course>();

	private List<Course> reqCourseList = new ArrayList<Course>();
	private List<Course> optCourseList = new ArrayList<Course>();

	Generate generate = new Generate();

	@Before
	public void setUp() {
		// create test fixture objects

		course1.setNum("CS101");
		course1.setDays("MWF");
		course1.setStartTime(9.0);
		course1.setEndTime(10.15);

		course2.setNum("ART101");
		course2.setDays("MW");
		course2.setStartTime(11.0);
		course2.setEndTime(12.00);

		course3.setNum("PE101");
		course3.setDays("F");
		course3.setStartTime(8.0);
		course3.setEndTime(8.5);

		course4.setNum("ECE101");
		course4.setDays("TR");
		course4.setStartTime(3.0);
		course4.setEndTime(4.15);

		course5.setNum("PHY101");
		course5.setDays("R");
		course5.setStartTime(1.0);
		course5.setEndTime(2.0);

		course6.setNum("BUS101");
		course6.setDays("M");
		course6.setStartTime(9.30); // intentional time conflicts with CS101
		course6.setEndTime(10.30);

		course7.setNum("SOC101");
		course7.setDays("TR");
		course7.setStartTime(1.0); // intentional conflict with PHY101
		course7.setEndTime(2.0);

		reqCourseList.add(course1);
		reqCourseList.add(course2);
		reqCourseList.add(course3);
		reqCourseList.add(course4);
		reqCourseList.add(course5);
		reqCourseList.add(course6);
		reqCourseList.add(course7);

		generate.GenerateSchedule(reqCourseList, optCourseList);
		scheduleM = generate.getScheduleM();
		scheduleT = generate.getScheduleT();
		scheduleW = generate.getScheduleW();
		scheduleR = generate.getScheduleR();
		scheduleF = generate.getScheduleF();

	}

	@Test
	public void testGetScheduleM() throws Exception {
		assertEquals(2, scheduleM.size());
		assertEquals("CS101", scheduleM.get(0).getNum());
		assertEquals("ART101", scheduleM.get(1).getNum());
		// assertEquals("BUS101", scheduleM.get(2).getNum()); // meant to cause
		// failure
	}

	@Test
	public void testGetScheduleT() throws Exception {
		assertEquals("ECE101", scheduleT.get(0).getNum());
		// assertEquals("SOC101", scheduleT.get(1).getNum()); // meant to cause
		// failure
	}

	@Test
	public void testGetScheduleW() throws Exception {
		assertEquals("CS101", scheduleW.get(0).getNum());
		assertEquals("ART101", scheduleW.get(1).getNum());
	}

	@Test
	public void testGetScheduleR() throws Exception {
		assertEquals("ECE101", scheduleR.get(0).getNum());
		assertEquals("PHY101", scheduleR.get(1).getNum());
		// assertEquals("SOC101", scheduleR.get(2).getNum()); // meant to cause
		// failure
	}

	@Test
	public void testGetScheduleF() throws Exception {
		assertEquals("CS101", scheduleF.get(0).getNum());
		assertEquals("PE101", scheduleF.get(1).getNum());
	}

}
