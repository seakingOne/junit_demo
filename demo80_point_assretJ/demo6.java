package demo80_point;

import org.assertj.core.api.JUnitSoftAssertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class demo6 {
	@Test
	void basic_assertions_example() {
	  assertThat("George Martin").as("great authors").isEqualTo("JRR Tolkien");  
	  assertThat(42).as("response to Everything").isGreaterThan(100); 
	  assertThat("Gandalf").isEqualTo("Sauron"); 
	}
	
	@Test
	void basic_soft_assertions_example() {
	  SoftAssertions softly = new SoftAssertions(); 

	  softly.assertThat("George Martin").as("great authors").isEqualTo("JRR Tolkien");  
	  softly.assertThat(42).as("response to Everything").isGreaterThan(100); 
	  softly.assertThat("test").isEqualTo("test"); 
	  softly.assertThat("Gandalf").isEqualTo("Sauron"); 

	  // Don't forget to call assertAll() otherwise no assertion errors are reported!
	  softly.assertAll(); 
	}
	
	@Rule
	public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

	@Test
	void junit4_soft_assertions_example() {
	  softly.assertThat("George Martin").as("great authors").isEqualTo("JRR Tolkien");  
	  softly.assertThat(42).as("response to Everything").isGreaterThan(100); 
	  softly.assertThat("Gandalf").isEqualTo("Sauron"); 
	  // No need to call softly.assertAll(), this is automatically done by the JUnitSoftAssertions rule
	}
}
