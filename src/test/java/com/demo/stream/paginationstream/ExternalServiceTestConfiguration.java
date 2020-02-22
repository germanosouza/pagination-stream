package com.demo.stream.paginationstream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Profile("test")
@Configuration
public class ExternalServiceTestConfiguration {

    @Bean
    @Primary
    public ExternalService<Long> externalService(){
        return new ExternalService<>() {
            private List<Long> dataList = initialize();

            private List<Long> initialize() {
                return Stream.iterate(1L, n-> n+1).limit(1000).collect(toList());
            }

            @Override
            public List<Long> fetch(int offset, int limit) {
                return dataList.stream().skip(offset).limit(limit).collect(Collectors.toList());
            }
        };
    }
}
