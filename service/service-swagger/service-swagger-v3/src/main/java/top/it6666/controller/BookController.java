package top.it6666.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @GetMapping("/{id}")
    public String findById() {
        return "findById";
    }

    @GetMapping("/")
    public String findBooks() {
        return "findBooks";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateBook() {
        return "updateBook";
    }
}