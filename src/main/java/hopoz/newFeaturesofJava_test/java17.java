package hopoz.newFeaturesofJava_test;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class java17 {
    public static void main(String[] args) {
        // EXP 增强的伪随机数生成器
        RandomGeneratorFactory<RandomGenerator> factory = RandomGeneratorFactory.of("L32X64MixRandom");
        RandomGenerator random = factory.create(System.nanoTime());
        random.nextInt(10);
        // EXP 密封类(转正) sealed关键字
        // 没有密封类之前，在 Java 中如果想让一个类不能被继承和修改，我们可以使用final
        // 关键字对类进行修饰。不过，这种方式不太灵活，直接把一个类的继承和修改渠道给堵死了。密封类可以对继承或者实现它们的类进行限制，这样这个类就只能被指定的类继承。

    }
}
