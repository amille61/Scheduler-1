package schedulerview.ycp.edu;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Before;
import org.junit.Test;

import scheduler.ycp.edu.server.FakeDatabase;
import scheduler.ycp.edu.shared.Course;

public class FakeDatabaseTest {

	private Course testCourse1 = new Course(null, 0, null, 0, null, 0, 0, null, null);
	private Course testCourse2 = new Course(null, 0, null, 0, null, 0, 0, null, null);
	private Course testCourse3 = new Course(null, 0, null, 0, null, 0, 0, null, null);
	private Course testCourse4 = new Course(null, 0, null, 0, null, 0, 0, null, null);
	private Course testCourse5 = new Course(null, 0, null, 0, null, 0, 0, null, null);

	@Before
	public void setUp() throws Exception {
		File fileName = new File("Course_List.csv");
		FakeDatabase database = new FakeDatabase();
		database.CreateFakeDatabase(fileName);
		testCourse1 = database.findCourse("CS101").get(0);
		testCourse2 = database.findCourse("ART101").get(3);
		testCourse3 = database.findCourse("PE110").get(1);
		testCourse4 = database.findCourse("WRT102").get(6);
		testCourse5 = database.findCourse("PHL221").get(0);

	}

	@Test
	public void testFakeDatabase() {
		// assertEquals(26, FakeDatabase.global_check);
		// assertEquals(4, FakeDatabase.global_check_size);
		// assertEquals("CS101", FakeDatabase.check_name);
		// assertEquals(7, FakeDatabase.global_check_temp1);
		// (0, FakeDatabase.global_check_temp2);

		assertEquals("CS101", testCourse1.getNum());
		assertEquals(20168, testCourse1.getCRNNum());
		assertEquals("Fund Comp Sci I", testCourse1.getName());
		assertEquals(2, testCourse1.getCredit());
		assertEquals("TR", testCourse1.getDays());
		assertEquals(8, testCourse1.getStartTime(), .1);
		assertEquals(9.5, testCourse1.getEndTime(), .1);
		assertEquals("Babcock", testCourse1.getInstructor());
		assertEquals("KEC 130", testCourse1.getRoom());

		assertEquals("ART101", testCourse2.getNum());
		assertEquals(20762, testCourse2.getCRNNum());
		assertEquals("Intro Art Apprec", testCourse2.getName());
		assertEquals(3, testCourse2.getCredit());
		assertEquals("MWF", testCourse2.getDays());
		assertEquals(12, testCourse2.getStartTime(), .1);
		assertEquals(12.5, testCourse2.getEndTime(), .1);
		assertEquals("Stabley", testCourse2.getInstructor());
		assertEquals("WOLF 316", testCourse2.getRoom());

	}

}