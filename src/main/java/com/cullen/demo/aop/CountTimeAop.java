package com.cullen.demo.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class CountTimeAop {

    @Around("@annotation(com.cullen.demo.aop.CountTime)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        MethodSignature msg = (MethodSignature) proceedingJoinPoint.getSignature();
        Object target =  proceedingJoinPoint.getTarget();
        String classMethodName =  target.getClass().getSimpleName() +  "." + msg.getName();

        // 获取注解参数
        Method method = target.getClass().getMethod(msg.getName(), msg.getParameterTypes());
//        CountTime countTime = method.getAnnotation(CountTime.class);

//        Object[] args = proceedingJoinPoint.getArgs();

        Object result = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();
//        String printString = "交易时间: " + after.toLocaleString() + " 交易码: " + countTime.svcSplrTxnCd() + " 执行时间 " +
//                (endTime-startTime) + " 方法名 " + classMethodName + " 参数 " + JSON.toJSONString(args);

        String printString = "方法名: " + classMethodName  + " 执行时间 " +
                (endTime-startTime);

        System.out.println(printString);

        return result;
    }
}
