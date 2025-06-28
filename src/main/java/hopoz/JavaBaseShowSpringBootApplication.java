package hopoz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class JavaBaseShowSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaBaseShowSpringBootApplication.class, args);
        log.info("server started!!!!!");

    }


}
