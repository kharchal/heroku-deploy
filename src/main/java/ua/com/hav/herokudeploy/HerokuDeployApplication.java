package ua.com.hav.herokudeploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class HerokuDeployApplication {

    public static void main(String[] args) {
        SpringApplication.run(HerokuDeployApplication.class, args);
    }

}

