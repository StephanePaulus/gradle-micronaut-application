package example.micronaut.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class HelloController {

    @Get("/hello")
    public String hello(){
        return "Hello world";
    }

    @Get("/test")
    public String test(){
        return "Test";
    }

    @Get("/other-test")
    public String otherTest(){
        return "Other test";
    }

    @Get("/yet-another-test")
    public String yetAnotherTest(){
        return "Yet-another test";
    }
}
