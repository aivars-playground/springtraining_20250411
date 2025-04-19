package org.example.base.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@Conditional(AppConf_Condition.class)
public class ConditionalAppConf {
    @Bean
    CommandLineRunner conditionalCommandLineRunner() {
        return args -> {
            System.out.println(" **** Running ConditionalAppConf...");
        };
    }
}

class AppConf_Condition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        var falseOnAttempt = FalseOnAttempt.conditionCheckResult();
        System.out.println("--------running checks in AppConf_Condition, returning:"+falseOnAttempt);
        return falseOnAttempt;
    }
}

class FalseOnAttempt {
    static AtomicInteger counter = new AtomicInteger();
    static int randomNumber = new Random().nextInt(1, 5);

    static boolean conditionCheckResult() {
        System.out.println("   /---FalseOnAttempt returns false on attempt:"+randomNumber);
        return counter.incrementAndGet() < randomNumber;
    }
}

    /*
        AppConf_Condition is executed multiple times (3)
        ConditionalAppConf is executed only once if true
     */