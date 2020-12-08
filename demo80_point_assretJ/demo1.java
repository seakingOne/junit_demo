package demo80_point;

import static org.assertj.core.api.Assertions.assertThat; 
import org.junit.jupiter.api.Test;

class demo1 {

	@Test
	  void a_few_simple_assertions() {
	    assertThat("The Lord of the Rings").isNotNull()   
	                                       .startsWith("The") 
	                                       .contains("Lord") 
	                                       .endsWith("Rings");                                   ; 
	  }
	
	
	@Test
	  void a_few_simple_assertions2() {
		// failing assertion, remember to call as() before the assertion!
	    assertThat("The Lord of the Rings")
	    									.as("The Lord of the Rings")	    									
	                                       .startsWith("The") 
	                                       .contains("Lord") 
	                                       .endsWith("test");                                   ; 
	  }

}
