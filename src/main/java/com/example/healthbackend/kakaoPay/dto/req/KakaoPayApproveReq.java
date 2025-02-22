package com.example.healthbackend.kakaoPay.dto.req;

import lombok.Data;

@Data
public class KakaoPayApproveReq {
    private String tid;
    private String partnerOrderId;
    private String partnerUserId;
    private String pgToken;
}

