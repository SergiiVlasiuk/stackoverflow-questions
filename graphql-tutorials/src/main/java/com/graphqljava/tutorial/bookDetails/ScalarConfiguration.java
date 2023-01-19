package com.graphqljava.tutorial.bookDetails;

import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Configuration(proxyBeanMethods = false)
public class ScalarConfiguration {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Bean
    public GraphQLScalarType dateScalar() {
        return GraphQLScalarType.newScalar()
                .name("LocalDate")
                .description("Java 8 LocalDate as scalar.")
                .coercing(new Coercing<Object, Object>() {
                    @Override
                    public String serialize(final Object dataFetcherResult) {
                        if (dataFetcherResult instanceof LocalDate) {
                            return formatter.format((LocalDate) dataFetcherResult);
                        } else {
                            throw new CoercingSerializeException("Expected a LocalDate object.");
                        }
                    }

                    @Override
                    public LocalDate parseValue(final Object input) {
                        try {
                            if (input instanceof String) {
                                return LocalDate.parse((String) input, formatter);
                            } else {
                                throw new CoercingParseValueException("Expected a String");
                            }
                        } catch (DateTimeParseException e) {
                            throw new CoercingParseValueException(String.format("Not a valid date: '%s'.", input), e
                            );
                        }
                    }

                    @Override
                    public LocalDate parseLiteral(final Object input) {
                        if (input instanceof StringValue) {
                            try {
                                return LocalDate.parse(((StringValue) input).getValue(), formatter);
                            } catch (DateTimeParseException e) {
                                throw new CoercingParseLiteralException(e);
                            }
                        } else {
                            throw new CoercingParseLiteralException("Expected a StringValue.");
                        }
                    }
                }).build();
    }

    // https://docs.spring.io/spring-graphql/docs/1.1.0-RC1/reference/html/#execution-graphqlsource-runtimewiring-configurer
    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer() {
        GraphQLScalarType scalarType = dateScalar();
        return wiringBuilder -> wiringBuilder.scalar(scalarType);
    }

/*
    // https://docs.spring.io/spring-graphql/docs/1.1.0-RC1/reference/html/#execution-graphqlsource
    @Bean
    public GraphQlSourceBuilderCustomizer sourceBuilderCustomizer() {
        GraphQLScalarType scalarType = dateScalar();
        return (builder) ->
                builder.configureGraphQl(graphQlBuilder ->
                        graphQlBuilder.executionIdProvider((query, operationName, context) -> null));
    }
*/

}