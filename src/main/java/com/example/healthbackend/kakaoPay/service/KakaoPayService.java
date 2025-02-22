package com.example.healthbackend.kakaoPay.service;

import com.example.healthbackend.config.RestTemplateConfig;
import com.example.healthbackend.kakaoPay.dto.req.KakaoPayApproveReq;
import com.example.healthbackend.kakaoPay.dto.req.KakaoPayReadyReq;
import com.example.healthbackend.kakaoPay.dto.res.KakaoPayApproveRes;
import com.example.healthbackend.kakaoPay.dto.res.KakaoPayReadyRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoPayService {
    private final RestTemplate restTemplate;

    @Value("${kakaopay.admin-key}")
    private String adminKey;

    @Value("${kakaopay.cid}")
    private String cid;

    @Value("${kakaopay.ready-url}")
    private String readyUrl;

    @Value("${kakaopay.approve-url}")
    private String approveUrl;

    public KakaoPayService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public KakaoPayReadyRes preparePayment(KakaoPayReadyReq kakaoPayReadyReq) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + adminKey); // 공백 추가
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", cid);
        params.add("partner_order_id", kakaoPayReadyReq.getPartnerOrderId());
        params.add("partner_user_id", kakaoPayReadyReq.getPartnerUserId()); // 오타 수정
        params.add("item_name", kakaoPayReadyReq.getItemName());
        params.add("quantity", String.valueOf(kakaoPayReadyReq.getQuantity()));
        params.add("total_amount", String.valueOf(kakaoPayReadyReq.getTotalAmount()));
        params.add("tax_free_amount", String.valueOf(kakaoPayReadyReq.getTaxFreeAmount()));
        params.add("approval_url", kakaoPayReadyReq.getApprovalUrl());
        params.add("cancel_url", kakaoPayReadyReq.getCancelUrl()); // 오타 수정
        params.add("fail_url", kakaoPayReadyReq.getFailUrl());

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);
        ResponseEntity<KakaoPayReadyRes> response = restTemplate.postForEntity(readyUrl, entity, KakaoPayReadyRes.class);

        return response.getBody();
    }

    public KakaoPayApproveRes approvePayment(KakaoPayApproveReq kakaoPayApproveReq){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK"+adminKey);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", cid);
        params.add("tid", kakaoPayApproveReq.getTid());
        params.add("partner_order_id", kakaoPayApproveReq.getPartnerOrderId());
        params.add("partner_user_id", kakaoPayApproveReq.getPartnerUserId());
        params.add("pg_token", kakaoPayApproveReq.getPgToken());

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

        ResponseEntity<KakaoPayApproveRes> response = restTemplate.postForEntity(approveUrl, entity, KakaoPayApproveRes.class);
        return response.getBody();
    }
}
