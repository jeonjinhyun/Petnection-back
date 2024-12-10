package com.jjh.mtvs.application.service.common;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {
    private final Counter signupCounter;
    private final MeterRegistry meterRegistry;

    public MetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        this.signupCounter = Counter.builder("mtvs_user_signup_total")  // 점(.) 대신 언더스코어(_) 사용
                .description("Total number of user signups")
                .register(meterRegistry);
    }

    public void incrementSignupCounter() {
        signupCounter.increment();
    }

    public void recordEndpointCall(String endpoint, String method, String status) {
        Counter.builder("mtvs_http_requests_total")  // 점(.) 대신 언더스코어(_) 사용
                .tag("endpoint", endpoint)
                .tag("method", method)
                .tag("status", status)
                .register(meterRegistry)
                .increment();
    }
}