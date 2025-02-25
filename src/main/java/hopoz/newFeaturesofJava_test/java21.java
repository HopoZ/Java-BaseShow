package hopoz.newFeaturesofJava_test;

import java.util.LinkedHashSet;
import java.util.SequencedCollection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java21 {
    public static void main(String[] args) {
        // EXP 字符串模板(preview)
        String name = "Java21";
        // System.out.println(STR.`Hello, \{name}!`); vscode java不支持开启预览功能
        // EXP 序列化集合
        SequencedCollection<String> seq = new LinkedHashSet<>();
        seq.add("a");
        // EXP 分代ZGC 默认关闭
        // java -XX:+UseZGC -XX:+ZGenerational ...
        // EXP 记录模式
        record Shape(String type, long unit) {
        }
        // 之前
        Shape circle = new Shape("Circle", 10);
        if (circle instanceof Shape shape) {

            System.out.println("Area of " + shape.type() + " is : " + Math.PI * Math.pow(shape.unit(), 2));
        }
        // 使用记录模式后
        circle = new Shape("Circle", 10);
        if (circle instanceof Shape(String type, long unit)) {
            System.out.println("Area of " + type + " is : " + Math.PI * Math.pow(unit, 2));
        }
        // EXP 外部函数和内存 API（第三次预览）

        // EXP 未命名模式和变量（预览）
        // EXP 虚拟线程
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10; i++) {
                int taskId = i;
                executor.submit(() -> {
                    System.out.println("Running task " + taskId + " in virtual thread: " + Thread.currentThread());
                });
            }
        }

        // EXP 未命名类和实例 main 方法 （预览）

    }

    // EXP switch 模式匹配
    static String formatterPatternSwitch(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> obj.toString();
        };
    }
}
