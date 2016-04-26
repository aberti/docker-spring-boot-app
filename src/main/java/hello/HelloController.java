package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Docker jest zajebisty";
    }

    @RequestMapping("/envs")
    public String envs() {
        StringBuilder buf = new StringBuilder();
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            buf.append(envName + " : " + env.get(envName) + "<br/>");
        }
        return buf.toString();
    }

    @RequestMapping("/app")
    public String app() {
        return System.getenv("HOSTNAME");
    }

}
