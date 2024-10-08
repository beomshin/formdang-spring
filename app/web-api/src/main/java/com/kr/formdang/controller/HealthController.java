package com.kr.formdang.controller;

import com.kr.formdang.model.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HealthController {

    /**
     * 헬스 체크 API
     * @return
     */
    @GetMapping("/public/health")
    public ResponseEntity<?> health() {
        log.info("헬스 요청");
        return ResponseEntity.ok().body(new SuccessResponse());
    }
}
