package com.company.incomplete;

import com.company.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.assertFalse;

public class JobTests {
    static Job test_job, test_job2, test_job3, test_job4, test_job5, test_job6, test_job7, test_job8, test_job9;
    @BeforeAll
    static void createJobObject(){
        test_job = new Job();
        test_job2 = new Job();
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job5 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality" +
                " control"), new CoreCompetency("Persistence"));
        test_job6 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality" +
                " control"), new CoreCompetency("Persistence"));
        test_job7 = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality" +
                " control"), new CoreCompetency("Persistence"));
        test_job8 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(""),
                new CoreCompetency("Persistence"));
        test_job9 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality" +
                " control"), new CoreCompetency(""));
    }



    // you can rename the tests, or delete them and rewrite them from scratch, but I went ahead and provided you the names of tests I created -- I followed the writeup pretty honestly
    @Test
    public void testSettingJobId() {
       //System.out.println(test_job.getId());
        //System.out.println((test_job2.getId()));

      assertFalse(test_job.getId()==test_job2.getId());

    }
    @Test
    public void testSettingJobIdIncrementsByOne(){
        assertTrue(test_job2.getId() - test_job.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(test_job3.getName() != "");
        assertEquals(3,test_job3.getId());
        assertTrue(test_job3.getLocation() instanceof Location);
        assertTrue(test_job3.getEmployer() instanceof Employer);
        assertTrue(test_job3.getPositionType() instanceof PositionType);
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_job3.equals(test_job4));

    }

    // I found the instructions around the three toString() tests a little confusing, so I created three tests following the three bullet points:
    // you can follow TDD if you want, or you can write the implementation first and then get the tests to pass, either is a fine approach
    @Test
    public void testToStringContainsBlankLines() {

        assertTrue(test_job3.toString().startsWith("\n"));
        assertTrue(test_job3.toString().endsWith("\n"));

    }



@Test
    public void testToStringHasLabelsForEachField() {
    String expected = String.format("\nID: %d\nName: %s\nEmployer: %s\nLocation: %s\nPosition Type: " +
      "%s\nCore Competency: %s\n", test_job3.getId(), test_job3.getName(),
            test_job3.getEmployer().getValue(), test_job3.getLocation().getValue(),
            test_job3.getPositionType().getValue(), test_job3.getCoreCompetency().getValue());
    String actual = test_job3.toString();
    assertEquals(expected, actual);

    }

    @Test
    public void testToStringDataNotAvailable() {
        String expected = String.format("\nID: %d\nName: Data not available\nEmployer: %s\nLocation: %s\nPosition " +
                        "Type: " +
                        "%s\nCore Competency: %s\n", test_job5.getId(),
                test_job5.getEmployer().getValue(), test_job5.getLocation().getValue(),
                test_job5.getPositionType().getValue(), test_job5.getCoreCompetency().getValue());
        String actual = test_job5.toString();
        assertEquals(expected, actual);

    }
}
