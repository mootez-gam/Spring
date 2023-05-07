package tn.esprit.ds.ski_mootez_g.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class PerformenceAspect {
//@Around cad before et after
    @Around("execution(public * tn.esprit.ds.ski_mootez_g.services.*.add*(..))")//executer chaque fonction dans le service qui commence par add
    public Object executionTime(ProceedingJoinPoint pjp ) throws Throwable {
        StopWatch stopWatch  = new StopWatch();
        stopWatch.start();
        Object o = pjp.proceed();
        stopWatch.stop();
        log.info("execution Time  of {} is {} ",pjp.getSignature().getName(),stopWatch.getTotalTimeMillis());
        return o;

    }

}
// pour calculer temp d execution fi ay methode n7eb 3leha