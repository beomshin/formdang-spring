package com.kr.formdang.controller.auth;

import com.kr.formdang.model.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {


    /**
     * 토큰 유횽성 검사 API
     * 본 서버에서는 NGINX를 통해 인증서버를 통해 인증 후 넘어온다.
     */
    @GetMapping("/admin/validate")
    public ResponseEntity<?> auth() {
        return ResponseEntity.ok().body(new SuccessResponse());
    }

}
