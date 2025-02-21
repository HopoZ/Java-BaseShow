package hopoz.io_test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class io_test {

    public static void main(String[] args) throws IOException {

        // FileInputStream
        try (InputStream fis = new FileInputStream("resources/input.txt")) {
            System.out.println("Number of remaining bytes:" + fis.available());
            int content;
            long skip = fis.skip(2);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            while ((content = fis.read()) != -1) {
                System.out.println((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 新建一个 BufferedInputStream 对象
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("resources/input.txt"))) {
            // 读取文件的内容并复制到 String 对象中
            String result = new String(bufferedInputStream.readAllBytes());
            System.out.println("result:" + result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //FileOutputStream
        try (FileOutputStream output = new FileOutputStream("resources/output.txt")) {
            byte[] array = "JavaGuide".getBytes();
            output.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
