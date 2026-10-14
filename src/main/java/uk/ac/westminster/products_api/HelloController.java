package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HelloController {

    //use get mapping to know which class to get the hello message
    @GetMapping("/hello") //the get request of hello will go the server
    public String hello(){
        return "hello from spring boots!"; //the sever is replies with this
    }

    @GetMapping("/status")
    public String status(){
        return "API running - " + LocalDate.now().toString();
    }

    @GetMapping("/goodbye")
    public String goodbye(){
        return "Goodbye from spring boot!";
    }
}
