package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from your Docker powered Spring Boot app!";
    }

    @RequestMapping("/envs")
    public String check() {
        StringBuilder buf = new StringBuilder();
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            buf.append(envName + " : " + env.get(envName) + "<br/>");
        }
        return buf.toString();
    }
    
}
