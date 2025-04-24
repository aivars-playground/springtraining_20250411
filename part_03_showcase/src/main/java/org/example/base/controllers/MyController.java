package org.example.base.controllers;

import org.example.base.models.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping(path = "/hi")
    public Example hi() {
        return new Example("Hello");
    }
}
