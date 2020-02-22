package com.demo.stream.paginationstream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

@Service
public class PaginationService<T> {

    @Autowired
    private ExternalService<T> externalService;

    public Stream<T> stream (int size, int batchSize) {
        var cursor = new Cursor();
        return Stream
                .generate(() -> next(cursor, size, batchSize))
                .takeWhile(not(List::isEmpty))
                .flatMap(List::stream);
    }

    private List<T> next(Cursor cursor, int size, int batchSize) {
        var fetchSize = Math.min(size - cursor.offset, batchSize);
        var result = externalService.fetch(cursor.offset, fetchSize);
        cursor.inc(result.size());
        return result;
    }

    private static class Cursor {
        private int offset;

        void inc(int by) {
            offset += by;
        }
    }
}


