package hopoz.test;

import hopoz.class_test.myClass;

public class Main {
    public static void main(String[] args) {
        Class <?> clazz = myClass.class;
        System.out.println(clazz);
        Lambda lambda = new Lambda();
        lambda.r1.run();
        lambda.r2.run();
    }
}
class Lambda {
     // 传统方式
     Runnable r1 = new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello");
        }
    };

    // Lambda 表达式
    Runnable r2 = () -> System.out.println("Hello");
}