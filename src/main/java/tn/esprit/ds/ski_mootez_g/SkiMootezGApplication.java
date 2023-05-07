package tn.esprit.ds.ski_mootez_g;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //activer le schedule
public class SkiMootezGApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkiMootezGApplication.class, args);
    }

}
