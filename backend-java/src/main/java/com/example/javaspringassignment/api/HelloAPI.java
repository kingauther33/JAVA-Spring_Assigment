package com.example.javaspringassignment.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class HelloAPI {

    @RequestMapping(method = RequestMethod.GET, path="hello")
    public String hello() { return "Hello world";}

    @RequestMapping(method = RequestMethod.GET, path = "goodbye")
    public String goodbye() { return "Goodbye to you";}

}
