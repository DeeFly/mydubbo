package com.gaofei.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by GaoQingming on 2017/9/8 0008.
 */
//@Order(9)
@Component
@Aspect
public class MyAopTest {

    //@Pointcut("(execution(* net.xuele..persist..*.*(..))|| execution(* net.xuele..mongo..*.*(..))|| execution(* net.xuele..redis..*.*(..)))")
    @Pointcut("execution(* com.gaofei.web.service..*(..))")
    public void pointCut(){}


    @Around(value = "pointCut()")
    public Object handleAop(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("myAOPTest come");
        Object object = joinPoint.proceed(joinPoint.getArgs());
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        if (object == null) return object;

        if (method != null && method.getAnnotation(MyAnnotationTest.class) != null) {
            object = (Integer) object + new Integer(2);
        }
        return object;
    }
}
