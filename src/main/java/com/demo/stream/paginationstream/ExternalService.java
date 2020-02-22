package com.demo.stream.paginationstream;

import java.util.List;

public interface ExternalService<T> {
    List<T> fetch(int offset, int limit);
}
