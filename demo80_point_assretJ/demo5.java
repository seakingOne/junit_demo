package demo80_point;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class demo5 {
	// assert exception
    @Test
    void test_exception_ok() {

        assertThatThrownBy(() -> divide(1, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("zero")
                .hasMessage("/ by zero");

        assertThatThrownBy(() -> {
            List<String> list = Arrays.asList("one", "two");
            list.get(2);
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("2");

    }

    int divide(int input, int divide) {
        return input / divide;
    }

    @Test
    public void bdd_exception_assertion_example() {
       // GIVEN
       String[] names = { "Pier ", "Pol", "Jak" };
       // WHEN
       Throwable thrown = catchThrowable(() -> System.out.println(names[9]));
       // THEN
       assertThat(thrown).isInstanceOf(ArrayIndexOutOfBoundsException.class)
                         .hasMessageContaining("9");
    }
    
    @Test
    public void exception_assertion_example() {
       assertThatIOException().isThrownBy(() -> { throw new IOException("boom!"); })
                              .withMessage("%s!", "boom")
                              .withMessageContaining("boom")
                              .withNoCause();
    }
    
    
}
