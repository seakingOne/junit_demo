package demo80_point;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class demo3 {
	@Test
	void testString() {
		// �ַ�������
		assertThat("test")
				.as("�ַ�����������")
		        .isNotBlank() // �Ƿ�Ϊ" "�ַ���		
				.isSubstringOf("test1") // �Ƿ�Ϊtest1��һ����
				.isSameAs("test") // ������Ԫ���Ƿ����
				.isNotEmpty() // �Ƿ�Ϊ���ַ���
				.isEqualTo("test") // �Ƿ����
				.isEqualToIgnoringCase("Test") // �Ƿ���ȣ����Դ�Сд��
				.isExactlyInstanceOf(String.class) // �Ƿ���ʵ��
				.isIn(Arrays.asList("test", "hello")) // �Ƿ����б���
				.isIn("test", "hello") // �Ƿ��ڲ����б���
				.isInstanceOfAny(String.class, Integer.class) // �Ƿ���ʵ�����κ�һ��
				.isNotNull() // �Ƿ�Ϊ��
				.contains("es") // �Ƿ����es�Ӵ�
				.startsWith("te") // te��ʼ
				.endsWith("st") // st����
				.matches(".e.t"); // �Ƿ�ƥ�� .e.t ��ʽ
		assertThat("").isNullOrEmpty();
	}

	@Test
	void testInt() {
		// ���ֶ���
		assertThat(new Integer(100))
				.as("���ֶ�������")
				.isEqualTo(100) // �Ƿ����
				.isBetween(0, 300) // �Ƿ���0��300֮��
				.isNotNull() // �Ƿ�ǿ�
				.isNotZero() // �Ƿ񲻵���0
				.isGreaterThanOrEqualTo(80) // �Ƿ��Լ����80
				.isLessThan(200) // �Ƿ�С��200
				.isPositive() // �Ƿ�������
				.isNotNegative() // �Ƿ��ǷǸ���
				.isIn(Arrays.asList(100, 200)) // �Ƿ����б���
				.isInstanceOf(Integer.class); // �Ƿ���Integer����
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
