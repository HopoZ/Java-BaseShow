package hopoz.newFeaturesofJava_test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class java8 {
    public static void main(String[] args) {
        System.out.println("Hello, Java 8!");

        // EXP 新 interface 的方法可以用default 或 static修饰

        // EXP Lambda 表达式
        // * Runnable 接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The runable now is using!");
            }
        }).start();
        // 用lambda
        new Thread(() -> System.out.println("It's a lambda function!")).start();

        // * Comparator 接口
        List<Integer> strings = Arrays.asList(1, 2, 3);

        Collections.sort(strings, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // Lambda
        Collections.sort(strings, (Integer o1, Integer o2) -> o1 - o2);
        // 分解开
        Comparator<Integer> comparator = (Integer o1, Integer o2) -> o1 - o2;
        Collections.sort(strings, comparator);

        // EXP 方法引用::是sugar

        // EXP stream API
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        Stream<String> stream = list.stream(); // 顺序流
        Stream<String> parallelStream = list.parallelStream(); // 并行流

        // EXP optional为解决NPE而生
        Optional<String> optional = Optional.of("bam");
        optional.isPresent(); // true

        // EXP 新的日期时间API
        // java.time.LocalDate
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }
}
