package tn.esprit.ds.ski_mootez_g.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspects {
    @Before("execution(public * tn.esprit.ds.ski_mootez_g.services.*.*(..))")  // public void //type de retour + esm il method + les methode qui commence par get get*
    //tn.esprit.ds.ski_mootez_g.services.*.get* //tous les methodes qui se trouve dans le service qui commence par get
    public void inMethod(JoinPoint jp)
    {
        log.info("in method"+jp.getSignature().getName());

    }

    @AfterReturning("execution(public * tn.esprit.ds.ski_mootez_g.services.*.*(..))")  // public void //type de retour + esm il method + les methode qui commence par get get*
    //tn.esprit.ds.ski_mootez_g.services.*.get* //tous les methodes qui se trouve dans le service qui commence par get
    public void outMethod(JoinPoint jp)
    {
        log.info("out method"+jp.getSignature().getName());

    }

    /*
    @After("execution(public * tn.esprit.ds.ski_mootez_g.services.*.*(..))")  // public void //type de retour + esm il method + les methode qui commence par get get*
    //tn.esprit.ds.ski_mootez_g.services.*.get* //tous les methodes qui se trouve dans le service qui commence par get
    public void outMethod(JoinPoint jp)
    {
        log.info("out method"+jp.getSignature().getName());

    }

    @AfterThrowing("execution(public * tn.esprit.ds.ski_mootez_g.services.*.*(..))")  // public void //type de retour + esm il method + les methode qui commence par get get*
    //tn.esprit.ds.ski_mootez_g.services.*.get* //tous les methodes qui se trouve dans le service qui commence par get
    public void outMethod(JoinPoint jp)
    {
        log.info("out method"+jp.getSignature().getName());

    }
    */
}
