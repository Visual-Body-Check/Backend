package com.example.healthbackend.kakaoPay.controller;

import com.example.healthbackend.kakaoPay.dto.req.KakaoPayApproveReq;
import com.example.healthbackend.kakaoPay.dto.req.KakaoPayReadyReq;
import com.example.healthbackend.kakaoPay.dto.res.KakaoPayApproveRes;
import com.example.healthbackend.kakaoPay.dto.res.KakaoPayReadyRes;
import com.example.healthbackend.kakaoPay.service.KakaoPayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kakaopay")
public class KakaoPayController {
    private final KakaoPayService kakaoPayService;

    public KakaoPayController(KakaoPayService kakaoPayService) {
        this.kakaoPayService = kakaoPayService;
    }

    @PostMapping("/ready")
    public ResponseEntity<KakaoPayReadyRes> preparePayment(@RequestBody KakaoPayReadyReq kakaoPayReadyReq){
        KakaoPayReadyRes response = kakaoPayService.preparePayment(kakaoPayReadyReq);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/approve")
    public ResponseEntity<KakaoPayApproveRes> approvePayment(@RequestBody KakaoPayApproveReq kakaoPayApproveReq){
        KakaoPayApproveRes response = kakaoPayService.approvePayment(kakaoPayApproveReq);
        return ResponseEntity.ok(response);
    }
}
