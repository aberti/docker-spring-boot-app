package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from your Docker powered Spring Boot app!";
    }


    @RequestMapping("/app")
    public String check() {
        String env = System.getenv("HOSTNAME");
        return env;
    }
    
}
