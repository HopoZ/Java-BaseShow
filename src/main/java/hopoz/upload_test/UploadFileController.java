package hopoz.upload_test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Slf4j
@RestController
public class UploadFileController {

    private static final String UPLOAD_DIR = "uploads/";

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Nice");
    }
    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        log.info("文件上传: {}", file.getOriginalFilename());

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("文件为空");
        }
//        if (!isAllowedType(file.getContentType())) {
//            return ResponseEntity.badRequest().body("文件类型不允许");
//        }
        if (file.getSize() > 5 * 1024 * 1024) {
            return ResponseEntity.badRequest().body("文件过大");
        }

        try {
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            // 修改文件名防止本地有同名文件
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR, filename);

            //通过Files.copy方法存储文件到本地目录
//            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            //通过MultipartFile的方法存储文件
            file.transferTo(new File("E:\\project\\code\\Java\\Java-BaseShow-SpringBoot\\uploads\\"+filename));
            return ResponseEntity.ok("上传成功：" + filename);
        } catch (IOException e) {
            log.error("文件上传失败", e);
            return ResponseEntity.status(500).body("上传失败");
        }
    }

    private boolean isAllowedType(String contentType) {
        return contentType != null && (
                contentType.equals("image/jpeg") ||
                        contentType.equals("image/png") ||
                        contentType.equals("application/pdf") ||
                        contentType.equals("text/plain")
        );
    }
}
