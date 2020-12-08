package demo04_point;

import org.junit.Test;

/**
 * JUnit TimeOut Test
 * The ��Time Test�� means if an unit test takes longer
 *  than the specified number of milliseconds to run, 
 *  the test will terminated and mark as failed.
 */
public class AssertTimeoutTest1 {
 
	@Test(timeout = 2000)  
	public void infinity() {  
		while (true);  
	}  
 
}
