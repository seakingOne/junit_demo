package demo04_point;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertTestModelTest {
	@Test 
	void testAssertThrows() {
		// 2：如果抛出的异常与设定的异常相同，则这一步的断言成功并返回一个异常的顶级父类
		Throwable exception = assertThrows(ArithmeticException.class, () -> {
			// 1：执行此语句会抛出一个ArithmeticException异常，被assertThrows方法捕获
			AssertTestModel.testThrowArithmeticException(2, 10);
		});
		// 3：接下来便可以对返回的异常进行一些其他的测试
		// 比如对异常的信息进行断言测试等。。
		assertEquals("The numB not allowed to '0'!!", exception.getMessage());
	}

}
