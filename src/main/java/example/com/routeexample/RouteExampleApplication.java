package example.com.routeexample;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RouteExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RouteExampleApplication.class, args);
    }

}
