import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ioBuffer {

    @Test
    void copy_pdf_to_another_pdf_buffer_stream() {
        // 记录开始时间
        System.out.println("开始复制PDF文件");
        long start = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("resources/C++ The Ultimate Beginners Guide to Learn C++ Programming Step-by-Step (Reed, Mark) (Z-Library).epub")); BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.pdf"))) {
            int content;
            while ((content = bis.read()) != -1) {
                bos.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用缓冲流复制PDF文件总耗时:" + (end - start) + " 毫秒");
    }

    @Test
    void copy_pdf_to_another_pdf_stream() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream("resources/C++ The Ultimate Beginners Guide to Learn C++ Programming Step-by-Step (Reed, Mark) (Z-Library).epub"); FileOutputStream fos = new FileOutputStream("copy.pdf")) {
            int content;
            while ((content = fis.read()) != -1) {
                fos.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用普通流复制PDF文件总耗时:" + (end - start) + " 毫秒");
    }
}
