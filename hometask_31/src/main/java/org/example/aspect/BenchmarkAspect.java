package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class BenchmarkAspect {

    @Pointcut("@annotation(org.example.aspect.Benchmark)")
    public void arroundAll() {}

    @Around("arroundAll()")
    public void logArround(ProceedingJoinPoint joinPoint) {
        long start = System.nanoTime();
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        String name = joinPoint.getSignature().getName();
        long time = System.nanoTime() - start;
        System.out.println(name + " : " + time);
    }
}
