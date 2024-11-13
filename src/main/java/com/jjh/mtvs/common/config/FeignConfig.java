package com.jjh.mtvs.common.config;

import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; // 전체 요청 및 응답을 로깅
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ErrorDecoder.Default(); // 기본 오류 디코더 사용
    }
}
