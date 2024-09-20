package com.example.rest_43_1.config;

import com.example.rest_43_1.dto.ErrorDto;
import com.example.rest_43_1.exc.RentServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return (s, response) -> {

            try (var inputStream = response.body().asInputStream()) {
                ObjectMapper objectMapper = new ObjectMapper();
                ErrorDto errorDto = objectMapper.readValue(inputStream, ErrorDto.class);
                return new RentServiceException(errorDto.getCode(), errorDto.getMessage());
            } catch (Exception e) {
                throw new RentServiceException(500, "you are bad java-developer");
            }
        };
    }
}
