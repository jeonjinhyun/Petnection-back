package com.jjh.mtvs.common.aop;

import com.jjh.mtvs.application.service.common.MetricsService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.HandlerMapping;

@Aspect
@Component
public class ApiMetricsAspect {
    private final MetricsService metricsService;
    private final MeterRegistry meterRegistry;

    public ApiMetricsAspect(MetricsService metricsService, MeterRegistry meterRegistry) {
        this.metricsService = metricsService;
        this.meterRegistry = meterRegistry;
    }

    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object measureApiMetrics(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String endpoint = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        if (endpoint == null) {
            endpoint = request.getRequestURI();
        }

        String method = request.getMethod();
        Timer.Sample sample = Timer.start(meterRegistry);

        try {
            Object result = joinPoint.proceed();
            String status = "success";
            metricsService.recordEndpointCall(endpoint, method, status);
            sample.stop(Timer.builder("mtvs_http_request_duration")  // 점(.) 대신 언더스코어(_) 사용
                    .tag("endpoint", endpoint)
                    .tag("method", method)
                    .tag("status", status)
                    .register(meterRegistry));
            return result;
        } catch (Exception e) {
            String status = "error";
            metricsService.recordEndpointCall(endpoint, method, status);
            sample.stop(Timer.builder("mtvs_http_request_duration")  // 점(.) 대신 언더스코어(_) 사용
                    .tag("endpoint", endpoint)
                    .tag("method", method)
                    .tag("status", status)
                    .register(meterRegistry));
            throw e;
        }
    }
}