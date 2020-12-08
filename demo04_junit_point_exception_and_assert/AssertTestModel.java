package demo04_point;

public class AssertTestModel {
	public static void testThrowArithmeticException(int numA,int numB){
        try {
            int result = numA/numB;
        }catch (ArithmeticException e){
            throw new ArithmeticException("The numB not allowed to '0'!!");
        }
    }
}
 