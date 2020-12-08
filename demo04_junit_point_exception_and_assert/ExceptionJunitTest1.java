package demo04_point;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.*;

/**
 * JUnit Expected Exception Test
 *
 */
public class ExceptionJunitTest1 {
  
	@Test(expected = ArithmeticException.class)  
	public void divisionWithException() {  
	    int i = divide(1,0);
	}  
   
	@Test
	public void divisionWithExceptionMsg() {
		try {
	         assertEquals( 1, divide(1,10),0 );
			fail();
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			assertEquals("/ by zero", e.getMessage());
		}
	}
	
	@Test
	public void exceptionTesting() {
	  Exception exception = assertThrows(ArithmeticException.class, () -> divide(1, 0));
	  assertEquals("/ by zero", exception.getMessage());
	}

	private int divide(int a, int b) {
	  return a / b;
	}
	
	
}
