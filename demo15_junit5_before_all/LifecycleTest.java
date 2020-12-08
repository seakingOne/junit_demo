package demo15_junit5_before_all;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LifecycleTest {
	@BeforeAll
    static void initAll() {
		System.out.println("@BeforeAll - oneTimeSetUp");
    }

    @BeforeEach
    void init() {
    	 System.out.println("@@BeforeEach - setUp");
    }

    @Test
    void succeedingTest() {
    	System.out.println("@test - succeedingTest");
    }

    @Test
    void failingTest() {
    	System.out.println("@test - failingTest");
        fail("a failing test");    	
    }

    @Test
    void skippedTest() {
    	System.out.println("@test - skippedTest");
    }

    @AfterEach
    void tearDown() {
    	System.out.println("@@AfterEach - tearDown");
    }

    @AfterAll
    static void tearDownAll() {
    	System.out.println("@@AfterAll - oneTimeTearDown");
    }
}
