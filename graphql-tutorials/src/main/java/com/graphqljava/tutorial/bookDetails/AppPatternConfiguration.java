package com.graphqljava.tutorial.bookDetails;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;

@Configuration
@ConfigurationProperties("app.patterns")
@Data
public class AppPatternConfiguration {

    String localDate;
    DateTimeFormatter localDateFormatter;

    @PostConstruct
    void init() {
        localDateFormatter = DateTimeFormatter.ofPattern(localDate);
    }
}
