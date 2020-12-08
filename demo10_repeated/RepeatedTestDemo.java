package demo10_repeated;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTestDemo {


	
	@DisplayName("�ظ�����")
	@RepeatedTest(value = 3)
	public void i_am_a_repeated_test() {
	    System.out.println("ִ�в���");
	}
	
	@DisplayName("�Զ��������ظ�����")
	@RepeatedTest(value = 3, name = "{displayName} �� {currentRepetition} ��")
	public void i_am_a_repeated_test_2() {
	    System.out.println("ִ�в���");
	}
}
