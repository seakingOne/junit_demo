package demo80_point;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class demo4 {
	@Test
	void testString() {
		// �ַ�������
		// �Ƿ�Ϊtest1��һ����
		 // ������Ԫ���Ƿ��� test���
		// �Ƿ�Ϊ���ַ���
		// �Ƿ����
		// �Ƿ���ȣ����Դ�Сд��
		// �Ƿ���Stringʵ��
		 // �Ƿ����б��У�this is a test��
		// �Ƿ��ڲ����б���
		// �Ƿ���ʵ�����κ�һ��
		// �Ƿ�Ϊ�� null
		 // �Ƿ���� the �Ӵ�
		 // te��ʼ
		// st����
		assertThat("test")
				.as("�ַ�����������")
				.isNotNull()
				.isEqualTo("test")
				.isEqualToIgnoringCase("Test")
		    	.isInstanceOf(String.class)
		 		.isIn("test1", "test")
		        .isIn(Arrays.asList("this", "is",  "a", "test"))
				.doesNotContain("the")
				.startsWith("te")
				.endsWith("st");
	}

	@Test
	void testInt() {
		// ���ֶ���
		// �Ƿ����
		// �Ƿ���0��300֮��
		// �Ƿ�ǿ�
		// �Ƿ񲻵���0
		// �Ƿ��Լ����80
		 // �Ƿ�С��200
		// �Ƿ�������
		// �Ƿ��ǷǸ���
		// �Ƿ����б���
		// �Ƿ���Integer����
		assertThat(new Integer(100))
				.as("���ֶ�������")
				.isEqualTo(100)
				.isBetween(0, 300)
				.isNotNull()
				.isGreaterThanOrEqualTo(80)
				.isLessThan(200)
				.isPositive()
				//.isNotPositive()
				.isIn(100, 200)
				.isInstanceOf(Integer.class);
	}

	@Test
	void testDate() {
		// ���ڶ���
		assertThat(new Date())
				.as("���ڶ�������")
				.isAfter("2018-08-01")
				.isAfterYear(2017)
				.isBetween("2018-01-01", "2018-08-31")
				.isEqualToIgnoringHours(new Date().toLocaleString())
				.isExactlyInstanceOf(Date.class)
				.isInSameHourAs(new Date())
				.isInThePast()
				.isToday();
	}

	@Test
	void testList() {
		// �б����
		assertThat(Arrays.asList("world", "hello"))
			.as("�б��������")
			.isNotEmpty()
			.isNotNull()
			.isInstanceOf(List.class)
			.isSubsetOf("hello", "world")
			.contains("hello")
			.containsOnlyOnce("world")
			.startsWith("world")
			.endsWith("hello");
	}
	@Test
	void testMap() {
		// �ֵ����
				Map foo = new HashMap();
				foo.put("A", 1);
				foo.put("B", 2);
				foo.put("C", 3);
				
				assertThat(foo)
						.as("�ֵ��������")
						.isNotNull() // �Ƿ�Ϊ��
						.isNotEmpty() // �Ƿ�sizeΪ0
						.hasSize(3) // size�Ƿ�Ϊ3
						.containsKeys("A") // �Ƿ����key
						.containsValue(1); // �Ƿ����value
	}
	@Test
	void testObject() {
		// �������
				User user1 = new User();
				user1.setName("Tom");
				user1.setAge(12);
				
				User user2 = new User();
				user2.setName("Tom");
				user2.setAge(12);
				
				User user3 = user1;
					
				assertThat(user1)
						.as("�����������")
						.isEqualToComparingFieldByField(user2) //user1��ÿ���ֶ��Ƿ���user2��ͬ
						.isExactlyInstanceOf(User.class) //user1�Ƿ���User��Ķ���
						.isSameAs(user3) //�Ƿ���ͬһ������
						.isNotNull() //�Ƿ�ǿ�
						.hasFieldOrProperty("name") //�Ƿ���name�ֶ�
						.hasFieldOrPropertyWithValue("age", 12); //�Ƿ���age�ֶΣ���ֵΪ12
	}
}
