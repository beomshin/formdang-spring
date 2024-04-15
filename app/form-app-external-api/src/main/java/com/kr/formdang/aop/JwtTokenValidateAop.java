package com.kr.formdang.aop;

import com.kr.formdang.common.GlobalCode;
import com.kr.formdang.exception.CustomException;
import com.kr.formdang.provider.JwtTokenProvider;
import com.kr.formdang.root.DefaultResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class JwtTokenValidateAop {

    @Pointcut("execution(* com.kr.formdang.controller.FileController.*(..))")
    public void filePointcut() {} // 파일 컨트롤러


    /**
     * AOP를 통한 토큰 헤더 검사
     *
     * 기존 컨트롤러는 인증 서버 통해 검사 로직 처리
     * multipart 경우는 어플케이션에서 유효성 검사
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("filePointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request =requestAttributes.getRequest();
        String token = request.getHeader("Authorization");
        log.info("[AOP] 헤더 토큰 검사 실행 : {}", token);
        try {
            if (StringUtils.isEmpty(token) || JwtTokenProvider.validateToken(token)) throw new CustomException(GlobalCode.FAIL_VALIDATE_TOKEN); // 그룹 폼은 로그인 권한 필요
            return pjp.proceed();
        } catch (CustomException e) {
            log.error("", e);
            return ResponseEntity.ok().body(new DefaultResponse(e.getCode()));
        }
    }
}
