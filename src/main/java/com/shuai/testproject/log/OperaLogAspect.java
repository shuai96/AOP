package com.shuai.testproject.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuai.testproject.response.BaseResponse;
import com.shuai.testproject.response.exception.SysException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 操作日志切面定义
 */
@Aspect
@Component
public class OperaLogAspect {

    private static Logger logger = LogManager.getLogger(OperaLogAspect.class);

    @Pointcut("@annotation(com.shuai.testproject.log.OperaLog)")
    public void operatorLog() {

    }

    @SuppressWarnings("rawtypes")
    @AfterReturning(returning = "result", pointcut = "operatorLog()&&@annotation(log)")
    public void afterReturn(JoinPoint joinPoint, BaseResponse result, OperaLog log) throws JsonProcessingException {

        StringBuilder sb = dealLog(joinPoint, log);
        sb.append(" | 错误码:").append(result.getRespCode());
        sb.append(" | 错误信息:").append(result.getRespDesc());
        sb.append(" | 出参:").append(result.getRespInfo().toString());
        logger.info(sb.toString());
    }


    @AfterThrowing(throwing = "exception", pointcut = "operatorLog()&&@annotation(log)")
    public void afterThrow(JoinPoint joinPoint, SysException exception, OperaLog log) throws JsonProcessingException {
        StringBuilder sb = dealLog(joinPoint, log);
        sb.append(" | 错误码:").append(exception.getCode());
        sb.append(" | 错误信息:").append(exception.getMessage());
        logger.info(sb.toString());
    }

    private StringBuilder dealLog(JoinPoint joinPoint, OperaLog log) throws JsonProcessingException {
        String argsJson = new ObjectMapper().writeValueAsString(joinPoint.getArgs());
        StringBuilder sb = new StringBuilder();
        sb.append("模块：").append(log.module());
        sb.append(" | 操作:").append(log.operate());
        sb.append(" | 接口名称:").append(joinPoint.getSignature().getName());
        sb.append(" | 入参:").append(argsJson);
        return sb;
    }

}

