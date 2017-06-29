package Aufgabe5;

import static org.junit.Assert.*;

import org.junit.Test;

public class HSPersonalTest {
	private HSPersonal test;
	@Test
	public void test() {
		test = HSPersonal.Student;
		assertEquals("ist falsch!", false, test.getGivesLessons() );
		
		test = HSPersonal.Profesor;
		assertEquals("ist falsch!", false, test.getIsAdminStaff() );
		
		test = HSPersonal.Dekan;
		assertEquals("ist richtig!", true, test.getHasOrgResp ());
	}


}
