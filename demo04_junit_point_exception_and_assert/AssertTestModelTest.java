package demo04_point;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertTestModelTest {
	@Test 
	void testAssertThrows() {
		// 2������׳����쳣���趨���쳣��ͬ������һ���Ķ��Գɹ�������һ���쳣�Ķ�������
		Throwable exception = assertThrows(ArithmeticException.class, () -> {
			// 1��ִ�д������׳�һ��ArithmeticException�쳣����assertThrows��������
			AssertTestModel.testThrowArithmeticException(2, 10);
		});
		// 3������������ԶԷ��ص��쳣����һЩ�����Ĳ���
		// ������쳣����Ϣ���ж��Բ��Եȡ���
		assertEquals("The numB not allowed to '0'!!", exception.getMessage());
	}

}
