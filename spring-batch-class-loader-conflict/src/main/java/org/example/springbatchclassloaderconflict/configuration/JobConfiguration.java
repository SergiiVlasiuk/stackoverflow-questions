package org.example.springbatchclassloaderconflict.configuration;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.example.springbatchclassloaderconflict.model.HeroXml;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

@Configuration
@Slf4j
public class JobConfiguration {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public StaxEventItemReader<HeroXml> customerItemReader() {
    XStreamMarshaller unmarshaller = new XStreamMarshaller();
    Map<String, Class> aliases = new HashMap<>();
    aliases.put("hero", HeroXml.class);
    unmarshaller.setAliases(aliases);
    StaxEventItemReader<HeroXml> reader = new StaxEventItemReader<>();
    reader.setResource(new ClassPathResource("/category/heroes.xml"));
    reader.setFragmentRootElementName("hero");
    reader.setUnmarshaller(unmarshaller);
    return reader;
  }

  @Bean
  public ItemWriter<HeroXml> customerItemWriter() {
    return items -> items.forEach(item -> log.info("item:\t\t{}", item));
  }

  @Bean
  public Step step1() {
    return stepBuilderFactory.get("step1")
        .allowStartIfComplete(true)
        .<HeroXml, HeroXml>chunk(2)
        .reader(customerItemReader())
/*
        .processor((ItemProcessor<HeroXml, HeroXml>) item -> {
          log.info(">> {}", item);
          return item;
        })
*/
        .writer(customerItemWriter())
        .build();
  }

  @Bean
  public Job job() {
    return jobBuilderFactory.get("job")
        .start(step1())
        .build();
  }
}
