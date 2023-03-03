package ua.com.alevel;

public class LambdaTest {

    public void test() {
        Student student = new StudentServiceImpl().create("1", "2", 10);
//        System.out.println("student = " + student);

        int sum;
        SumUtil sumUtilImpl = new SumUtilImpl();
        sum = sumUtilImpl.sum(3, 7);
        System.out.println("sum = " + sum);

        SumUtil sumUtilAbs = new SumUtil() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
        sum = sumUtilAbs.sum(3, 8);
        System.out.println("sum = " + sum);

        SumUtil sumUtilLambda = (a, b) -> a + b;
        sum = sumUtilLambda.sum(4,8);
        System.out.println("sum = " + sum);
    }
}
