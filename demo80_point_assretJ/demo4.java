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
		// 字符串断言
		// 是否为test1的一部分
		 // 对象内元素是否与 test相等
		// 是否为空字符串
		// 是否相等
		// 是否相等（忽略大小写）
		// 是否是String实例
		 // 是否在列表中（this is a test）
		// 是否在参数列表中
		// 是否是实例中任何一个
		// 是否不为空 null
		 // 是否包含 the 子串
		 // te开始
		// st结束
		assertThat("test")
				.as("字符串断言描述")
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
		// 数字断言
		// 是否相等
		// 是否在0，300之间
		// 是否非空
		// 是否不等于0
		// 是否大约等于80
		 // 是否小于200
		// 是否是正数
		// 是否是非负数
		// 是否在列表中
		// 是否是Integer类型
		assertThat(new Integer(100))
				.as("数字断言描述")
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
		// 日期断言
		assertThat(new Date())
				.as("日期断言描述")
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
		// 列表断言
		assertThat(Arrays.asList("world", "hello"))
			.as("列表断言描述")
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
		// 字典断言
				Map foo = new HashMap();
				foo.put("A", 1);
				foo.put("B", 2);
				foo.put("C", 3);
				
				assertThat(foo)
						.as("字典断言描述")
						.isNotNull() // 是否不为空
						.isNotEmpty() // 是否size为0
						.hasSize(3) // size是否为3
						.containsKeys("A") // 是否包含key
						.containsValue(1); // 是否包含value
	}
	@Test
	void testObject() {
		// 对象断言
				User user1 = new User();
				user1.setName("Tom");
				user1.setAge(12);
				
				User user2 = new User();
				user2.setName("Tom");
				user2.setAge(12);
				
				User user3 = user1;
					
				assertThat(user1)
						.as("对象断言描述")
						.isEqualToComparingFieldByField(user2) //user1的每个字段是否与user2相同
						.isExactlyInstanceOf(User.class) //user1是否是User类的对象
						.isSameAs(user3) //是否是同一个对象
						.isNotNull() //是否非空
						.hasFieldOrProperty("name") //是否含有name字段
						.hasFieldOrPropertyWithValue("age", 12); //是否含有age字段，且值为12
	}
}
