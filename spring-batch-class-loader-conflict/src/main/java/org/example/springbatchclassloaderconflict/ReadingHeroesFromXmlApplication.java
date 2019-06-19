package org.example.springbatchclassloaderconflict;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class ReadingHeroesFromXmlApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReadingHeroesFromXmlApplication.class, args);
  }
}
