package com.demo.stream.paginationstream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
public class PaginationServiceTest {

    @Autowired
    private PaginationService<Long> service;

    @Test
    public void givenHugeList_whenPageSizeIsSmall_ThenCheckDataRetrieved() {
        var result = service.stream(1000, 100).collect(toList());
        List<Long> expectedResult = Stream.iterate(1L, n->n+1).limit(1000).collect(toList());
        assertEquals(expectedResult, result);
    }
}
