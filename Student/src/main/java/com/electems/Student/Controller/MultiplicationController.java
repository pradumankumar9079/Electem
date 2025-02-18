package com.electems.Student.Controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.electems.Student.Service.MultiplicationService;

@RestController
@RequestMapping("/multiples")
public class MultiplicationController {

    private final MultiplicationService multiplicationService;

    public MultiplicationController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @GetMapping
    public ResponseEntity<List<Integer>> getMultiples(
            @RequestParam int number,
            @RequestParam int limit) {
        return ResponseEntity.ok(multiplicationService.getMultiples(number, limit));
    }
}
