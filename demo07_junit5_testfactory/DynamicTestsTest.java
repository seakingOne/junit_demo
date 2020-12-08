
package demo07_junit5_testfactory;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.DynamicTest.stream;

class DynamicTestsTest {

    private PositiveNumberPredicate predicate = new PositiveNumberPredicate();
  
    @BeforeAll
    static void setUpClass() {
        System.out.println("@BeforeAll method");
    }

    @AfterAll
    static void tearDownClass() {
        System.out.println("@AfterAll method");
    }

    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach method");
    }
    @TestFactory
    public Collection<DynamicTest> simpleDynamicTest() {
    	return Collections.singleton(dynamicTest("simple dynamic test", () -> assertTrue(2 > 1)));
    }
    
    @TestFactory
    public Stream<DynamicTest> streamDynamicTest() {
     return stream( Stream.of("Hello", "World").iterator(),
           (word) -> String.format("Test - %s", word),
           (word) -> assertTrue(word.length() > 4)
     );
    }
    @TestFactory
    Iterator<DynamicTest> positiveNumberPredicateTestCases() {
        return asList(
                dynamicTest("negative number", () -> assertFalse(predicate.check(-1))),
                dynamicTest("zero", () -> assertFalse(predicate.check(0))),
                dynamicTest("positive number", () -> assertTrue(predicate.check(1))),
                dynamicTest("test 3>5 ", () -> assertFalse(3>5))
        ).iterator();
    }
    
    @TestFactory
     Collection<DynamicTest> dynamicTestsFromCollection() {
        return Arrays.asList(
                dynamicTest("1st dynamic test", () -> assertTrue(true)),
                dynamicTest("2nd dynamic test", () -> assertEquals(4, 2 * 2))
        );
    }
}
