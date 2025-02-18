package com.electems.Student.Service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MultiplicationService {

    public List<Integer> getMultiples(int number, int limit) {
        return IntStream.rangeClosed(1, limit)
                .map(i -> i * number)
                .boxed()
                .collect(Collectors.toList());
    }
}
